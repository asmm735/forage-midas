package com.jpmc.midascore.service;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.foundation.Incentive;
import org.springframework.web.client.RestTemplate;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TransactionRecordRepository transactionRecordRepository;

        private RestTemplate restTemplate = new RestTemplate();
    
    @Transactional
    public void processTransaction(Transaction transaction) {
        // Validate sender ID
        Optional<UserRecord> senderOpt = userRepository.findById(transaction.getSenderId());
        if (!senderOpt.isPresent()) {
            System.out.println("Invalid sender ID: " + transaction.getSenderId());
            return;
        }
        
        // Validate recipient ID
        Optional<UserRecord> recipientOpt = userRepository.findById(transaction.getRecipientId());
        if (!recipientOpt.isPresent()) {
            System.out.println("Invalid recipient ID: " + transaction.getRecipientId());
            return;
        }
        
        UserRecord sender = senderOpt.get();
        UserRecord recipient = recipientOpt.get();
        
        // Validate sender has sufficient balance
        if (sender.getBalance() < transaction.getAmount()) {
            System.out.println("Insufficient balance for sender: " + sender.getName());
            return;
        }

                // Call incentives API
        String incentiveUrl = "http://localhost:8080/incentive";
        Incentive incentive = restTemplate.postForObject(incentiveUrl, transaction, Incentive.class);
        float incentiveAmount = (incentive != null) ? incentive.getAmount() : 0;
        
        // All validations passed - process the transaction
        // Update balances
        sender.setBalance(sender.getBalance() - transaction.getAmount());
        recipient.setBalance(recipient.getBalance() + transaction.getAmount() + incentiveAmount);        
        // Save updated users
        userRepository.save(sender);
        userRepository.save(recipient);
        
        // Record the transaction
        TransactionRecord record = new TransactionRecord(sender, recipient, transaction.getAmount(), incentiveAmount);        transactionRecordRepository.save(record);
        
        System.out.println("Transaction processed successfully: " + sender.getName() + " -> " + recipient.getName() + " : " + transaction.getAmount());
    }
}

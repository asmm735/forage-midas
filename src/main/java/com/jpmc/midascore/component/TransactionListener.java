package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @Value("${general.kafka-topic}")
    private String kafkaTopic;

    @KafkaListener(topics = "#{@transactionListener.kafkaTopic}", groupId = "midas-core")
    public void listen(Transaction transaction) {
        // TODO: Process transaction in later tasks
        System.out.println("Received transaction: " + transaction);
    }
}

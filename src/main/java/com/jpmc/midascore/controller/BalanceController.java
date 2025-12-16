package com.jpmc.midascore.controller;

import com.jpmc.midascore.model.Balance;
import com.jpmc.midascore.model.User;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    private final UserRepository userRepository;

    public BalanceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/balance")
    public Balance getBalance(@RequestParam("userId") String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new Balance(0.0);
        }
        return new Balance(user.getBalance());
    }
}

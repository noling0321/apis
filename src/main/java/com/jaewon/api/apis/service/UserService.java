package com.jaewon.api.apis.service;

import com.jaewon.api.apis.model.User;
import com.jaewon.api.apis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void findAll() {
        for(User user : this.userRepository.findAll()) {
            System.out.println(user);
        }

    }

    public void initializeUsers() {
        User user1 = User.builder()
                .email("example@sample.com")
                .name("Mr. Example")
                .phone("01000000000")
                .build();

        User user2 = User.builder()
                .email("example2@sample.com")
                .name("Mr. Sample")
                .phone("01011111111")
                .build();

        User user3 = User.builder()
                .email("example3@sample.com")
                .name("Ms. Sample Data")
                .phone("01012345678")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.flush();
    }
}

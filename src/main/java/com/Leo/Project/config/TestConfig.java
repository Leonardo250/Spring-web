package com.Leo.Project.config;

import com.Leo.Project.entities.User;
import com.Leo.Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Maria Brown", "Maria@gmail.com","219665874","123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "219887463","123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}

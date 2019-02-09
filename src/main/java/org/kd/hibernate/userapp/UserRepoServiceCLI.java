package org.kd.hibernate.userapp;

import org.kd.hibernate.userapp.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepoServiceCLI implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserRepoServiceCLI.class);

    @Override
    public void run(String... args) throws Exception {
        var user = new User("Barbara", "Admin");
        userRepository.save(user);
        log.info("new user created " + user + " with UserRepository.save() method");
        Optional<User> userWithId1 = userRepository.findById(1L);

        userWithId1.ifPresent(user1 -> log.info("Retrieved user " + user1));

        log.info("Retrieving all users: ");
        userRepository.findAll().forEach(u -> log.info(u.toString()));
    }
}

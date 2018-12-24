package org.kd.hibernate;

import org.kd.hibernate.entity.User;
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
        User user = new User("Barbara", "Admin");
        userRepository.save(user);
        log.info("new user created " + user + " with UserRepository.save() method");
        Optional<User> userWithId1 = userRepository.findById(1L);

        if (userWithId1.isPresent()) {
            log.info("Retrieved user " + userWithId1.get());
        }

        log.info("Retrieving all users: ");
        userRepository.findAll().forEach(u -> log.info(u.toString()));
    }
}

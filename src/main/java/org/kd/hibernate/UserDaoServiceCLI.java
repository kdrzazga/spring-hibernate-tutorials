package org.kd.hibernate;

import org.kd.hibernate.entity.User;
import org.kd.hibernate.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCLI implements CommandLineRunner {

    @Autowired
    private UserDAOService userDAOService;

    private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCLI.class);

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jacek", "Admin");
        long id = userDAOService.insert(user);
        log.info("new user created " + user);
    }
}

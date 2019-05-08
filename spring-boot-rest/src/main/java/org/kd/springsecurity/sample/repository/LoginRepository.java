package org.kd.springsecurity.sample.repository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.kd.springsecurity.sample.Roles;

public class LoginRepository {

    public UserDetails getAdmin() {
        return User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1")
                .roles(Roles.ADMIN.name())
                .build();
    }

    public UserDetails getUser() {
        return User.withDefaultPasswordEncoder()
                .username("user")
                .password("user1")
                .roles(Roles.USER.name())
                .build();
    }

    public UserDetails getModerator() {
        return User.withDefaultPasswordEncoder()
                .username("mod")
                .password("mod1")
                .roles(Roles.MODERATOR.name())
                .build();
    }

}

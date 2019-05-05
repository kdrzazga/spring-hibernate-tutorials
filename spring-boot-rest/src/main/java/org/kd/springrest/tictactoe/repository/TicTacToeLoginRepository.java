package org.kd.springrest.tictactoe.repository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import springsecurity.sample.Roles;

public class TicTacToeLoginRepository {

    public UserDetails getPlayerX() {
        return User.withDefaultPasswordEncoder()
                .username("playerx")
                .password("pass")
                .roles("PLAYER")
                .build();
    }

    public UserDetails getPlayerO() {
        return User.withDefaultPasswordEncoder()
                .username("playero")
                .password("pass")
                .roles("PLAYER")
                .build();
    }
}

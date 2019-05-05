package org.kd.springrest.tictactoe.config;

import org.kd.springrest.tictactoe.repository.TicTacToeLoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        var repo = new TicTacToeLoginRepository();
        return new InMemoryUserDetailsManager(repo.getPlayerO(), repo.getPlayerX());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic() //allow for auth with login and password - necessary for Postman to login
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/place/{x},{y}").authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();

    }
}

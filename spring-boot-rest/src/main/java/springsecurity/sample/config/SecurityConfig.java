package springsecurity.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import springsecurity.sample.Roles;
import springsecurity.sample.repository.LoginRepository;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        var repo = new LoginRepository();

        var user = repo.getUser();

        var admin = repo.getAdmin();

        var moderator = repo.getModerator();

        //user stored in memory
        return new InMemoryUserDetailsManager(user, admin, moderator);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //applyAdminOnlyConfig(http);
        applyUserConfig(http);
    }

    private void applyUserConfig(HttpSecurity http) throws Exception {
        http.httpBasic() //allow for auth with login and password - necessary for Postman to login
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/quote").permitAll()
                .antMatchers(HttpMethod.POST, "/quote").hasRole(Roles.MODERATOR.name())
                .antMatchers(HttpMethod.DELETE, "/quote").hasRole(Roles.ADMIN.name())
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()

/*                .authorizeRequests()//when dealing a request auth will be required
                .antMatchers("/hello").permitAll()
                .anyRequest().hasRole(Roles.ADMIN.name())
                .and()
                .formLogin().permitAll()
                .and()
                .logout()// endpoint /logout added to functionality
                .permitAll()*/;
    }
}

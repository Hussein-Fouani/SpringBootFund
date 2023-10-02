package com.hf.springbootfund.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class securityConfig {

//    @Bean
  /*  public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}12345")
                .roles("Employee")
                .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}12345")
                .roles("Employee", "Manager")
                .build();
        UserDetails fouad = User.builder()
                .username("fouad")
                .password("{noop}12345")
                .roles("Employee", "Manager", "Admin")
                .build();

        return new InMemoryUserDetailsManager(john, mary, fouad);
    }*/

    @Bean
    public UserDetailsManager manager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity.authorizeHttpRequests(securityConfig ->
                        securityConfig.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("Employee")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("Admin")
                                .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("Manager")
                                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyRole("Admin", "Manager")
                ).build();

    }
}
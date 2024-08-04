package com.example.projects.configs;

import com.example.projects.dto.authentication.UserAuthenticated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticatedUserConfiguration {

    @Bean
    public UserAuthenticated userAuthenticated() {
        return new UserAuthenticated();
    }

}

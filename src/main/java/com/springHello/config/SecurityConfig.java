package com.springHello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

/**
 * Created by mar1 on 2/9/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration{
}

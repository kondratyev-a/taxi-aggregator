package com.kondratyev.taxiaggregator.configs;

import com.kondratyev.taxiaggregator.configs.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtFilter jwtFilter;

    @Value( "${use-debugging-config:false}" )
    private boolean useDebuggingConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        if (useDebuggingConfig) {
            // config to connect by H2 console
            http.authorizeRequests().antMatchers("/").permitAll().and()
                    .authorizeRequests().antMatchers("/console/**").permitAll();
            http.csrf().disable();
            http.headers().frameOptions().disable();
        } else {
            // main config
            http.csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers("/login", "/register").permitAll()
                    .anyRequest().authenticated();
        }

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

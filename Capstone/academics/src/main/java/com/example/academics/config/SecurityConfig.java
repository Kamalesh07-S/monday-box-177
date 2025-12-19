package com.example.academics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf().disable()

            .authorizeRequests()
                .antMatchers("/login", "/css/**", "/js/**").permitAll()
                .antMatchers("/student/**").hasAuthority("STUDENT")
                .antMatchers("/faculty/**").hasAuthority("FACULTY")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
            .and()

            .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler((request, response, authentication) -> {

                    String role = authentication.getAuthorities().toString();

                    if (role.contains("ADMIN")) {
                        response.sendRedirect("/admin/dashboard");
                    } else if (role.contains("FACULTY")) {
                        response.sendRedirect("/faculty/dashboard");
                    } else {
                        response.sendRedirect("/student/dashboard");
                    }
                })
                .permitAll()
            .and()

            .logout()
                .logoutSuccessUrl("/login")
                .permitAll();

        return http.build();
    }
}

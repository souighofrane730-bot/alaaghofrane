package com.fst.immobilier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/catalogue", "/catalogue/**", "/register", "/css/**", "/js/**", "/uploads/**").permitAll()
                .requestMatchers("/agent/**").hasAnyRole("AGENT", "ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
            .username("ahmed.benali@agence.tn") // email admin
            .password(passwordEncoder.encode("admin"))
            .roles("ADMIN")
            .build();

        UserDetails agent = User.builder()
            .username("mouna.trabelsi@agence.tn") // email agent
            .password(passwordEncoder.encode("agent"))
            .roles("AGENT")
            .build();

        UserDetails client = User.builder()
            .username("youssef.mansour@mail.tn") // email client
            .password(passwordEncoder.encode("client"))
            .roles("CLIENT")
            .build();

        return new InMemoryUserDetailsManager(admin, agent, client);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

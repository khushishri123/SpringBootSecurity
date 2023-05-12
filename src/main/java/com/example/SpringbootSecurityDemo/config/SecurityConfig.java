package com.example.SpringbootSecurityDemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain userConfig(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().
//                authorizeHttpRequests(authorize-> authorize.requestMatchers("/home/admin").permitAll().anyRequest().
//                authenticated()).formLogin();
//        return httpSecurity.build();
//    }

//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests(httpRequest -> httpRequest.mat
//                .permitAll().anyRequest().authenticated())
//                .csrf().disable()
//                .formLogin(formLogin -> formLogin.loginPage("/login")
//                        .loginProcessingUrl("/login"));
//        return httpSecurity.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails admin= User.withUsername("Ram").password(passwordEncoder().encode("Ram")).roles("ADMIN").build();
        UserDetails normal=User.builder().username("raj").password(passwordEncoder().encode("raj")).roles("NORMAL").build();
        return new InMemoryUserDetailsManager(admin,normal);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        try {
            httpSecurity.
                    authorizeHttpRequests((auth) -> auth.requestMatchers("/home/admin/**").permitAll().requestMatchers("/home/normal").hasRole("NORMAL").anyRequest().authenticated()).
                    formLogin().and().httpBasic();
            return httpSecurity.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

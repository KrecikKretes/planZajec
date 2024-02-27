package com.zawisza.planZajec.config;

import com.zawisza.planZajec.Connections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers(mvc.pattern("/**")))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/update").hasRole("ADMIN")
                        .requestMatchers("/complete").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .headers(headers -> headers.frameOptions((HeadersConfigurer.FrameOptionsConfig::sameOrigin)))
                .httpBasic(Customizer.withDefaults());
        http.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
        http.logout(logout -> logout
                .logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    UserDetailsService users(@Autowired PasswordEncoder pwEnc) {
        UserDetails user = User.builder()
                .username("user")
                .password(pwEnc.encode("top"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username(Connections.username)
                .password(pwEnc.encode(Connections.password))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

package com.example.spring_auth_learn.jdbc.config;


import com.example.spring_auth_learn.jdbc.services.CustomUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    CustomUserService userService;

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Database auth
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override                         
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll();
//        http.authorizeRequests().anyRequest().authenticated();

        http.authorizeRequests((request) -> request
                .antMatchers("/h2-console/**")
                .permitAll().anyRequest()
                .authenticated()
        ).httpBasic();

        http.formLogin();

        http.csrf().disable().headers().frameOptions().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

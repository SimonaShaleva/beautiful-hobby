package com.example.krasivohobi.config;

import com.example.krasivohobi.service.impl.KrasivoHobiDBUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final KrasivoHobiDBUserService krasivoHobiDBUserService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(KrasivoHobiDBUserService krasivoHobiDBUserService,
                                     PasswordEncoder passwordEncoder) {
        this.krasivoHobiDBUserService = krasivoHobiDBUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests().
                antMatchers("/js/**", "/css/**", "/img/**").permitAll()
                .antMatchers("/", "/users/login", "/users/register").permitAll()
                .antMatchers("/**").authenticated()
                .and().
                formLogin().
                loginPage("/users/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/users/login-error");//todo
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(krasivoHobiDBUserService)
                .passwordEncoder(passwordEncoder);
    }
}

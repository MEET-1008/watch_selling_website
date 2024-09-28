package com.codeWithBrinda.config;

import com.codeWithBrinda.Service.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguser {






    @Autowired
    private SecurityCustomUserDetailService securityCustomUserDetailService;

    @Autowired
    private OAuthAuthenicationSuccessHandler handler;

    @Autowired
    private customeSucessHandler CustomeSucessHandler;

    @Autowired
    AuthFailtureHandler authFailureHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        url configure  url is private or not
        http.authorizeHttpRequests(authorize -> {
            authorize.requestMatchers("admin/**").hasRole("ADMIN");
            authorize.requestMatchers("user/**").permitAll();
            authorize.anyRequest().permitAll();

        });


//        http.formLogin(Customizer.withDefaults());
//        http.formLogin(formLogin -> {
//            formLogin.loginPage("/login");
//            formLogin.loginProcessingUrl("/authenticate12");
//            formLogin.usernameParameter("email");
//            formLogin.passwordParameter("password");
//            formLogin.successForwardUrl("/user/dashboard");
//            formLogin.failureForwardUrl("/login?error=true");
////            formLogin.successHandler(CustomeSucessHandler);
////            formLogin.failureHandler(authFailureHandler);
//
//        });

        http.formLogin(formLogin -> {
            formLogin.loginPage("/login");
            formLogin.loginProcessingUrl("/authenticate12");
//            formLogin.successForwardUrl("/user/dashboard");
            formLogin.failureForwardUrl("/login?error=true");
            formLogin.usernameParameter("email");
            formLogin.passwordParameter("password");
            formLogin.failureHandler(authFailureHandler);
            formLogin.successHandler(CustomeSucessHandler);


        });


        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);

        // oauth configurations

        http.oauth2Login(oauth -> {
            oauth.loginPage("/login");
            oauth.successHandler(handler);
        });


        http.logout(logoutForm -> {
            logoutForm.logoutUrl("/logout");
            logoutForm.logoutSuccessUrl("/login?logout=true");
        });

        return http.build();
    }



}


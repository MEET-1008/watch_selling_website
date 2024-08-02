package com.codeWithMeet.scm.scm0_2.config;

import com.codeWithMeet.scm.scm0_2.Repo.RoleRepo;
import com.codeWithMeet.scm.scm0_2.Repo.UserRepo;
import com.codeWithMeet.scm.scm0_2.entities.Providers;
import com.codeWithMeet.scm.scm0_2.entities.Roles;
import com.codeWithMeet.scm.scm0_2.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuthAuthenicationSuccessHandler implements AuthenticationSuccessHandler {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException {

        // identify the provider

        var oauth2AuthenicationToken = (OAuth2AuthenticationToken) authentication;

        String authorizedClientRegistrationId = oauth2AuthenicationToken.getAuthorizedClientRegistrationId();

        System.out.println(authorizedClientRegistrationId);

        var oauthUser = (DefaultOAuth2User) authentication.getPrincipal();

//        print the all element
        oauthUser.getAttributes().forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        User user = new User();


        user.setEmailverified(
             true
        );


        if (authorizedClientRegistrationId.equalsIgnoreCase("google")) {

            // google
            // google attributes

            user.setEmail(oauthUser.getAttribute("email"));
            user.setProfilepic(oauthUser.getAttribute("picture"));
            user.setUsername(oauthUser.getAttribute("name"));
            user.setProviderUserId(oauthUser.getName());
//            user.setPassword(oauthUser.getAttribute("password"));
            user.setPassword(passwordEncoder.encode(oauthUser.getName() + "@2024"));
            user.setProvider(Providers.GOOGLE);
            user.setAbout("This account is created using google.");

        } else if (authorizedClientRegistrationId.equalsIgnoreCase("github")) {

            // github

            if(oauthUser.getAttribute("email") == null) {
                user.setEmail(oauthUser.getName()+ "@gmail.com");
            }
            user.setEmail(oauthUser.getAttribute("email"));
            user.setPassword(passwordEncoder.encode(oauthUser.getName() + "@2024"));
            user.setProfilepic(oauthUser.getAttribute("avatar_url"));
            user.setUsername(oauthUser.getAttribute("login"));
            user.setProviderUserId(oauthUser.getName());
            user.setProvider(Providers.GITHUB);
            user.setAbout("This account is created using github");

        } else {

            System.out.println("OAuthAuthenicationSuccessHandler: Unknown provider");
        }

        User user2 = userRepo.findByEmail(user.getEmail()).orElse(null);

        if (user2 == null) {



            userRepo.save(user);

            Roles roles = roleRepo.findById(502).get();
            user.getRoles().add(roles);
            userRepo.save(user);


            System.out.println("user saved email id is :" + user.getEmail());


        }

        new DefaultRedirectStrategy().sendRedirect(request, response, "/user/dashboard");

    }

}
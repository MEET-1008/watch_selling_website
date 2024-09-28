package com.codeWithBrinda.config;

import java.io.IOException;

import com.codeWithBrinda.helper.MessageHelper;
import com.codeWithBrinda.helper.MessageType;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthFailtureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.setAttribute("message", MessageHelper.builder().content( exception.getMessage() ).type(MessageType.red).build());

        if (exception instanceof DisabledException) {

            // user is disabled
            session.setAttribute("message", MessageHelper.builder().content( " user is disable...! " ).type(MessageType.red).build());

            response.sendRedirect("/login");
        } else {
            System.out.println("Authentication failed: " + exception.getMessage());
            response.sendRedirect("/login?error=true");
            // request.getRequestDispatcher("/login").forward(request, response);

        }

    }

}
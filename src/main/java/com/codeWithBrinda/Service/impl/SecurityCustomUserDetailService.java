package com.codeWithBrinda.Service.impl;

import com.codeWithBrinda.Repo.UserRepo;
import com.codeWithBrinda.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityCustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) {

        System.out.println(" 5896 *******************" + email);
        User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        return user;


    }
}

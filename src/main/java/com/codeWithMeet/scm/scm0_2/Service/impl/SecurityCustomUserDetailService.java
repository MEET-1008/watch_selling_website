package com.codeWithMeet.scm.scm0_2.Service.impl;

import com.codeWithMeet.scm.scm0_2.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityCustomUserDetailService  implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) {

        System.out.println(" 5896 *******************");
//        upne user ko load karna he
       return userRepo.findByEmail(email).orElse(null);


    }
}

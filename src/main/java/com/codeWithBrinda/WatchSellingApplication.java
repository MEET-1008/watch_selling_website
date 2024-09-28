package com.codeWithBrinda;

import com.codeWithBrinda.Repo.RoleRepo;
import com.codeWithBrinda.entities.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WatchSellingApplication implements CommandLineRunner {

    @Autowired
    RoleRepo roleRepo;

    public static void main(String[] args) {

        SpringApplication.run(WatchSellingApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {

        Roles rols1 = new Roles();
        rols1.setId(501);
        rols1.setName("ROLE_ADMIN");

        Roles rols2 = new Roles();
        rols2.setId(502);
        rols2.setName("ROLE_USER");

        List<Roles> rols11 = List.of(rols1, rols2);

        roleRepo.saveAll(rols11);


    }
}

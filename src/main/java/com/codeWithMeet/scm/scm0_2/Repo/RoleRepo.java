package com.codeWithMeet.scm.scm0_2.Repo;

import com.codeWithMeet.scm.scm0_2.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {
}

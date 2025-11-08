package com.vishnu.resumeGen.repository;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {
    UserDetails findByFirstNameIgnoreCase(String firstName);
}


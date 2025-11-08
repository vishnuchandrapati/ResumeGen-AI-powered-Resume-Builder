package com.vishnu.resumeGen.repository;

import com.vishnu.resumeGen.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<UserRegistration, String> {

    boolean existsByUserMail(String userMail);
    UserRegistration findByUserMail(String userMail);
}

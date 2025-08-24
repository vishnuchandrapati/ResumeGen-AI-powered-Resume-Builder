package com.vishnu.resumeGen.repository;

import com.vishnu.resumeGen.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<UserRegistration, Long> {
}

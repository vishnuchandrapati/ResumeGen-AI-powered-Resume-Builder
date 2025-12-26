package com.vishnu.resumeGen.repository;

import com.vishnu.resumeGen.model.UserEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEducationRepo extends JpaRepository<UserEducation, Long> {
}

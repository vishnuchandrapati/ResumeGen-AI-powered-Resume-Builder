package com.vishnu.resumeGen.repository;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.model.userEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEducationRepo extends JpaRepository<userEducation, Long> {

}

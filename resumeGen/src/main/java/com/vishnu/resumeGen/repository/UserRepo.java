package com.vishnu.resumeGen.repository;

import com.vishnu.resumeGen.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {
    UserDetails findByUserMail(String userMail);



}


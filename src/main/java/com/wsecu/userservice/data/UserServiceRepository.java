package com.wsecu.userservice.data;

import com.wsecu.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserServiceRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
    User findByUserName(String userName);
    //set SQL query to update email
    @Modifying
    @Query("update User u set u.email = ?1 where u.id = ?2")
    void setUserEmailById(String email, Long id);

    //set SQL query to update username
    @Modifying
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    void setUsernameById(String userName, Long id);
}

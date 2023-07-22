package com.naveen.springboot_frontend.UserRepo;

import com.naveen.springboot_frontend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public User findByUsernameAndPassword(String username, String password);
}

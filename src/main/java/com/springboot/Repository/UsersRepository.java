package com.springboot.Repository;

import com.springboot.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String userName);
}

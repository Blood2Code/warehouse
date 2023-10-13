package com.example.wherehouse.repository;

import com.example.wherehouse.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserLogin, Long> {
    Optional<UserLogin> findByEmail(String email);
}

package com.dev.springfestbackend.repo;

import com.dev.springfestbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}

package com.dev.springfestbackend.repo;

import com.dev.springfestbackend.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepo extends JpaRepository<Stage, Long> {
}

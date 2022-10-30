package com.dev.springfestbackend.repo;

import com.dev.springfestbackend.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepo extends JpaRepository<Performance, Long> {
}

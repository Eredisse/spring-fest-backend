package com.dev.springfestbackend.repo;

import com.dev.springfestbackend.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepo extends JpaRepository<Singer, Long> {
}

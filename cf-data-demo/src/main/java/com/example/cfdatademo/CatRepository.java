package com.example.cfdatademo;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface CatRepository extends JpaRepository<Cat, Long> {
}

package com.example.test_project.repository;

import com.example.test_project.entity.Docs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestProjectRepo extends JpaRepository<Docs, Long> {
}

package com.example.test_project.service;

import com.example.test_project.entity.Docs;

import java.util.List;

public interface TestProjectService {

    List<Docs> getAllDocs();
    Docs getById(Long id);
    void create(Docs docs);
    void update(Long id, Docs docs);
    void delete(Long id);
}

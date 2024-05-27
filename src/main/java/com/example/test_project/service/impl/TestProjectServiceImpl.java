package com.example.test_project.service.impl;

import com.example.test_project.entity.Docs;
import com.example.test_project.repository.TestProjectRepo;
import com.example.test_project.service.TestProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestProjectServiceImpl implements TestProjectService {
    private final TestProjectRepo testProjectRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Docs> getAllDocs() {
        return testProjectRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Docs getById(Long id) {
        return testProjectRepo.findById(id).orElseThrow(() -> new RuntimeException("Записи с указанным id нет в БД"));
    }

    @Override
    @Transactional
    public void create(Docs docs) {
        testProjectRepo.save(docs);
    }

    @Override
    @Transactional
    public void update(Long id, Docs docs) {
        Docs updatedDocs = testProjectRepo.findById(id).orElseThrow(() -> new RuntimeException("Записи с указанным id нет в БД"));
        updatedDocs.setType(docs.getType());
        updatedDocs.setDate(docs.getDate());
        updatedDocs.setName(docs.getName());
        testProjectRepo.save(updatedDocs);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        testProjectRepo.findById(id).orElseThrow(() -> new RuntimeException("Записи с указанным id нет в БД"));
        testProjectRepo.deleteById(id);
    }
}

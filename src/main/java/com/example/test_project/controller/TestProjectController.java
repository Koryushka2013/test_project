package com.example.test_project.controller;

import com.example.test_project.entity.Docs;
import com.example.test_project.service.TestProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestProjectController {

    private final TestProjectService testProjectService;

    @GetMapping("/docs")
    public ResponseEntity<List<Docs>> getAllDocs() {
        return ResponseEntity.ok(testProjectService.getAllDocs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docs> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(testProjectService.getById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestParam(name = "id", required = false) Long id, @RequestBody Docs docs) {
        if (id == null)
            testProjectService.create(docs);
        else
            testProjectService.update(id, docs);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        testProjectService.delete(id);

        return ResponseEntity.ok().build();
    }
}

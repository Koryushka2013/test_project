package com.example.test_project;

import com.example.test_project.entity.Docs;
import com.example.test_project.repository.TestProjectRepo;
import com.example.test_project.service.TestProjectService;
import com.example.test_project.service.impl.TestProjectServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TestProjectApplicationTests {
    TestProjectRepo testProjectRepo = Mockito.mock(TestProjectRepo.class);
    TestProjectService testProjectService = new TestProjectServiceImpl(testProjectRepo);

    @Test
    void getDocsById() {
        Long id = 2L;
        Docs docs = new Docs(2L, "efe", "dv", "123");
        Mockito.when(testProjectRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(docs));

        Docs getById = testProjectService.getById(id);
        Assertions.assertEquals(getById, docs);
    }

}

package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTestSuite {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testSaveTask() {
        // Given
        Task task = new Task("task title", "task content");

        // When
        taskRepository.save(task);
        long id = task.getId();

        // Then
        Assert.assertNotEquals(0, id);

        // Clean up
        taskRepository.delete(task);
    }

}
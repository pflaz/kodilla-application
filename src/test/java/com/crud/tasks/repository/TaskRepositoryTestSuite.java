package com.crud.tasks.repository;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


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
        try {
            Assert.assertNotEquals(0, id);
        } finally {
            // Clean up
            taskRepository.delete(id);
        }
    }

    @Test
    public void testFindAll() {
        // Given
        Task task1 = new Task( "task1 title", "task1 content");
        Task task2 = new Task( "task2 title", "task2 content");
        taskRepository.save(task1);
        taskRepository.save(task2);
        long id1 = task1.getId();
        long id2 = task2.getId();

        // When
        List<Task> retrievedTaskList = taskRepository.findAll();
        Task retrievedTask1 = retrievedTaskList.get(0);
        Task retrievedTask2 = retrievedTaskList.get(1);

        // Then
        try {
            Assert.assertEquals(2, retrievedTaskList.size());
            Assert.assertEquals("task1 title", retrievedTask1.getTitle());
            Assert.assertEquals("task1 content", retrievedTask1.getContent());
            Assert.assertEquals("task2 title", retrievedTask2.getTitle());
            Assert.assertEquals("task2 content", retrievedTask2.getContent());
        } finally {
            taskRepository.delete(id1);
            taskRepository.delete(id2);
        }
    }

    @Test
    public void testFindById() throws TaskNotFoundException {
        // Given
        Task task = new Task( "task title", "task content");
        taskRepository.save(task);
        long taskId = task.getId();

        // When
        Task retrievedTask = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);

        // Then
        try {
            Assert.assertEquals("task title", retrievedTask.getTitle());
            Assert.assertEquals("task content", retrievedTask.getContent());
        } finally {
            taskRepository.delete(taskId);
        }
    }

}
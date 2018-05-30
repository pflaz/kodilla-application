package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() {
        // Given
        Task taskToRetrieve1 = new Task(1L, "task1 title", "task1 content");
        Task taskToRetrieve2 = new Task(2L, "task2 title", "task2 content");
        List<Task> taskListToRetrieve = new ArrayList<>();
        taskListToRetrieve.add(taskToRetrieve1);
        taskListToRetrieve.add(taskToRetrieve2);
        when(taskRepository.findAll()).thenReturn(taskListToRetrieve);

        // When
        List<Task> retrievedTaskList = dbService.getAllTasks();

        // Then
        Assert.assertEquals(2, retrievedTaskList.size());
        Assert.assertEquals(1L, retrievedTaskList.get(0).getId());
        Assert.assertEquals("task1 title", retrievedTaskList.get(0).getTitle());
        Assert.assertEquals("task1 content", retrievedTaskList.get(0).getContent());
        Assert.assertEquals(2L, retrievedTaskList.get(1).getId());
        Assert.assertEquals("task2 title", retrievedTaskList.get(1).getTitle());
        Assert.assertEquals("task2 content", retrievedTaskList.get(1).getContent());
    }


    @Test
    public void testGetTask() throws TaskNotFoundException {
        // Given
        Task taskToRetrieve = new Task(1L, "task title", "task content");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(taskToRetrieve));
        // When
        Task retrievedTask = dbService.getTask(1L).orElseThrow(TaskNotFoundException::new);

        // Then
        Assert.assertEquals(1L, retrievedTask.getId());
        Assert.assertEquals("task title", retrievedTask.getTitle());
        Assert.assertEquals("task content", retrievedTask.getContent());
    }

    @Test
    public void testSaveTask() {
        // Given
        Task task = new Task("task title", "task content");
        Task taskToRetrieve = new Task(1L, "task title", "task content");
//        when(taskRepository.save(any(Task.class))).thenReturn(taskToRetrieve);
        when(taskRepository.save(task)).thenReturn(taskToRetrieve);

        // When
        Task retrievedTask = dbService.saveTask(task);

        // Then
        Assert.assertEquals(1, retrievedTask.getId());
        Assert.assertEquals("task title", retrievedTask.getTitle());
        Assert.assertEquals("task content", retrievedTask.getContent());
    }
}
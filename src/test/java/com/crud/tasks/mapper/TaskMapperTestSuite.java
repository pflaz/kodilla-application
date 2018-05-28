package com.crud.tasks.mapper;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.dto.TaskDto;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    DbService dbService;

    @Test
    public void testTaskMapper() throws TaskNotFoundException {

        // Given
        TaskDto taskDto = new TaskDto("task title", "task content");
        // When
        Task task = taskMapper.mapToTask(taskDto);
        dbService.saveTask(task);
        long taskId = task.getId();
        Task retrievedTask = dbService.getTask(taskId).orElseThrow(TaskNotFoundException::new);
        List<Task> retrievedTaskList= dbService.getAllTasks();
        TaskDto retrievedTaskDto = taskMapper.mapToTaskDto(retrievedTask);
        long retrievedTaskId = retrievedTaskDto.getId();


        // Then
        assertEquals(taskId, retrievedTaskId);
        assertEquals("task title", retrievedTaskDto.getTitle());
        assertEquals("task content", retrievedTaskDto.getContent());
        assertEquals(1, retrievedTaskList.size());

        // Clean up
        dbService.deleteTask(taskId);

    }

}
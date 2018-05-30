package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.dto.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testMapToTask() {

        // Given
        TaskDto taskDto = new TaskDto(1L, "task title", "task content");
        // When
        Task task = taskMapper.mapToTask(taskDto);

        // Then
        assertEquals(1L, task.getId());
        assertEquals("task title", task.getTitle());
        assertEquals("task content", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        // Given
        Task task = new Task(1L, "task title", "task content");

        // When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        // Then
        assertEquals(1L, taskDto.getId());
        assertEquals("task title", taskDto.getTitle());
        assertEquals("task content", taskDto.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        // Given
        Task task1 = new Task(1L, "task1 title", "task1 content");
        Task task2 = new Task(2L, "task2 title", "task2 content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        // When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        // Then
        assertEquals(2, taskDtoList.size());
        assertEquals(1L, taskDtoList.get(0).getId());
        assertEquals("task1 title", taskDtoList.get(0).getTitle());
        assertEquals("task1 content", taskDtoList.get(0).getContent());
        assertEquals(2L, taskDtoList.get(1).getId());
        assertEquals("task2 title", taskDtoList.get(1).getTitle());
        assertEquals("task2 content", taskDtoList.get(1).getContent());

    }


}
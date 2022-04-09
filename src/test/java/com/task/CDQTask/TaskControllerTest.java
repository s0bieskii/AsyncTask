package com.task.CDQTask;

import static org.junit.jupiter.api.Assertions.*;

import com.task.CDQTask.task.controller.TaskController;
import com.task.CDQTask.task.dto.TaskRecord;
import com.task.CDQTask.task.model.Task;
import com.task.CDQTask.task.service.TaskService;
import com.task.CDQTask.task.utils.Config;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    @Mock
    private TaskController taskController;

    @Test
    public void testMockito(){
        //given
        TaskRecord taskAddRecord = new TaskRecord(3, 3);
        //when
        Mockito.when(taskController.createTask(taskAddRecord)).thenReturn(ResponseEntity.ok(Mockito.anyLong()));
        //then
        ResponseEntity<Long> response = taskController.createTask(taskAddRecord);
        assertTrue(response.getStatusCode().value() == HttpStatus.OK.value());
    }
}

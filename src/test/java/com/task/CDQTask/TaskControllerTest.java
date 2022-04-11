package com.task.CDQTask;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.task.CDQTask.task.controller.TaskController;
import com.task.CDQTask.task.dto.TaskAddRecord;
import com.task.CDQTask.task.dto.TaskIdRecord;
import com.task.CDQTask.task.model.Task;
import java.net.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    @Mock
    private TaskController taskController;

    @Test
    public void createTaskWithCorrectBaseAndExponentValueShouldReturn202HTTPStatus(){
        //given
        TaskAddRecord taskToAdd = new TaskAddRecord(5, 5);
        //when
        when(taskController.createTask(taskToAdd))
                .thenReturn(ResponseEntity.accepted().build());
        //then
        assertEquals(HttpStatus.ACCEPTED.value(), taskController.createTask(taskToAdd).getStatusCodeValue());
    }

    @Test
    public void createTaskShouldReturnResponseEntityTaskIdRecordBody(){
        //given
        TaskAddRecord taskToAdd = new TaskAddRecord(5, 5);
        Task savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setBase(5);
        savedTask.setExponent(5);
        TaskIdRecord record = new TaskIdRecord(savedTask.getId());
        //when
        when(taskController.createTask(taskToAdd)).thenReturn(ResponseEntity.accepted()
                .body(record));
        //then
        assertEquals(record, taskController.createTask(taskToAdd).getBody());
    }

}

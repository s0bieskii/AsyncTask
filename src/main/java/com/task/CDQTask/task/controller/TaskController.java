package com.task.CDQTask.task.controller;

import com.task.CDQTask.task.dto.TaskDto;
import com.task.CDQTask.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    public final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity createTask(@RequestBody TaskDto task){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity readTask(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity readAllTasks(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}

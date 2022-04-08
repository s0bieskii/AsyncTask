package com.task.CDQTask.task.controller;

import com.task.CDQTask.task.dto.TaskDto;
import com.task.CDQTask.task.service.TaskService;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    public static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());
    public final TaskService taskService;

    public TaskController(TaskService taskService) {
        LOGGER.info("Create TaskController with auto injected: " + taskService.getClass().getName());
        this.taskService = taskService;
    }

    //Czy zabezpieczyć przed mnożeniem przez ujemne?
    @Async
    @PostMapping("/")
    public ResponseEntity createTask(@RequestBody TaskDto task) {
        LOGGER.info("Request POST: /api/tasks/ " + task);
        return ResponseEntity.accepted().body(taskService.createTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity readTask(@PathVariable Long id) {
        LOGGER.info("Request GET: /id   id=" + id);
        return ResponseEntity.ok().body(taskService.getTask(id));
    }

    @GetMapping("/")
    public ResponseEntity readAllTasks() {
        LOGGER.info("Request GET: / ");
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }
}

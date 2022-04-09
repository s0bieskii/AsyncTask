package com.task.CDQTask.task.controller;

import com.task.CDQTask.task.dto.TaskRecord;
import com.task.CDQTask.task.model.Task;
import com.task.CDQTask.task.service.TaskService;
import java.util.List;
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

    @Async
    @PostMapping("/")
    public ResponseEntity<Long> createTask(@RequestBody TaskRecord task) {
        LOGGER.info("Request POST: /api/tasks/ " + task);
        return ResponseEntity.accepted().body(taskService.createTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> readTask(@PathVariable Long id) {
        LOGGER.info("Request GET: /id   id=" + id);
        var task = taskService.getTask(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> readAllTasks() {
        LOGGER.info("Request GET: / ");
        var tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }
}

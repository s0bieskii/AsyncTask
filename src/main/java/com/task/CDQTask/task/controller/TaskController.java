package com.task.CDQTask.task.controller;

import com.task.CDQTask.task.dto.TaskAddRecord;
import com.task.CDQTask.task.dto.TaskIdRecord;
import com.task.CDQTask.task.model.Task;
import com.task.CDQTask.task.service.TaskService;
import java.util.List;
import java.util.logging.Logger;
import javax.validation.Valid;
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

    public static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());
    public final TaskService taskService;

    public TaskController(TaskService taskService) {
        LOGGER.info("Create TaskController with auto injected: " + taskService.getClass().getName());
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity<TaskIdRecord> createTask(@Valid @RequestBody TaskAddRecord task) {
        LOGGER.info("Request POST: /api/tasks/ " + task);
        Task savedTask = taskService.createTask(task);
        taskService.processTask(savedTask);
        return ResponseEntity.accepted().body(new TaskIdRecord(savedTask.getId()));
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

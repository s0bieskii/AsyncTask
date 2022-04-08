package com.task.CDQTask.task.service;

import com.task.CDQTask.task.dto.TaskDto;
import com.task.CDQTask.task.model.Task;
import com.task.CDQTask.task.repository.TaskRepository;
import com.task.CDQTask.task.utils.Config;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public static final Logger LOGGER = Logger.getLogger(TaskService.class.getName());
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        LOGGER.info("Create TaskService with auto injected: " + taskRepository.getClass().getName());
        this.taskRepository = taskRepository;
    }

    public Long createTask(TaskDto taskDto) {
        LOGGER.info("createTask taskDto: " + taskDto);
        Task task = new Task();
        task.setBase(taskDto.getBase());
        task.setExponent(taskDto.getExponent());
        task.setStatus(Config.STATUS_RUNNING);
        task = taskRepository.save(task);
        processTask(task);
        return task.getId();
    }

    public Task getTask(Long id) {
        LOGGER.info("getTask id: " + id);
        return taskRepository.getById(id);
    }

    public List<Task> getAllTasks() {
        LOGGER.info("getAllTasks: ");
        return taskRepository.findAll();
    }

    @Async
    private void processTask(Task task) {
        int currentResult = task.getBase();
        for (int i = 1; i < task.getExponent(); i++) {
            currentResult = currentResult * task.getExponent();
            task.setProgress(calculateProgress(i, task.getExponent()));
            taskRepository.save(task);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        task.setStatus(Config.STATUS_FINISHED);
        task.setResult(currentResult);
        task.setProgress(100);
        taskRepository.save(task);
    }

    private int calculateProgress(int currentStep, int allSteps) {
        return Math.round((100 / allSteps) * currentStep);
    }


}

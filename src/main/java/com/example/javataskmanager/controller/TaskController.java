package com.example.javataskmanager.controller;

import com.example.javataskmanager.model.Task;
import com.example.javataskmanager.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    //Constructor Injection
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Operation(summary = "Create New Task")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @Operation(summary = "Get All Tasks")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Operation(summary = "Update Task Status by ID")
    @PatchMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody String status) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        return taskRepository.save(task);
    }

    @Operation(summary = "Delete Task by ID")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
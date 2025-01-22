package com.example.javataskmanager.controller;

import com.example.javataskmanager.model.Task; //Model
import com.example.javataskmanager.repository.TaskRepository; //Data Access
import io.swagger.v3.oas.annotations.Operation; //Swagger Annotations
import org.springframework.web.bind.annotation.*; //Annotations, @RestController, @GetMapping, etc.

import java.util.List; //Holds a group of tasks.

@RestController //Spring MVC Controller returing JSON objects.
@RequestMapping("/tasks") //Prefixes endpoints.
public class TaskController {

    private final TaskRepository taskRepository; //Final reference to TaskRepository
    //Constructor Injection
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        //Spring Boot best practice for Constructor Injection.
        //Automatically provides the correct TaskRepository instance.
    }

    @Operation(summary = "Create New Task")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        //@RequestBody expects JSON and automatically deserializes it into a Task object.
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
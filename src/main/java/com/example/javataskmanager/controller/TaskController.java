package com.example.javataskmanager.controller;

import com.example.javataskmanager.model.Task; //Model
import com.example.javataskmanager.service.TaskService; //Service Layer
import io.swagger.v3.oas.annotations.Operation; //Swagger Annotations
import org.springframework.web.bind.annotation.*; //Annotations, @RestController, @GetMapping, etc.

import java.util.List; //Holds a group of tasks.

//TaskController no longer call taskRepository, it instead delegates all the logic to taskService.

@RestController //Spring MVC Controller returning JSON objects.
@RequestMapping("/tasks") //Prefixes endpoints.
public class TaskController {

    //Added a Service Layer to remove Business Logic from Controller.
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Create New Task")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        //@RequestBody expects JSON and automatically deserializes it into a Task object.
        return taskService.createTask(task);
    }

    @Operation(summary = "Get All Tasks")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Operation(summary = "Update Task Status by ID")
    @PatchMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody String status) {
        return taskService.updateTaskStatus(id, status);
    }

    @Operation(summary = "Delete Task by ID")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
package com.example.javataskmanager.service;

import com.example.javataskmanager.model.Task;
import com.example.javataskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplement implements TaskService {

    private final TaskRepository taskRepository; //Final reference to TaskRepository

    //Constructor Injection
    public TaskServiceImplement(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        //Spring Boot best practice for Constructor Injection.
        //Automatically provides the correct TaskRepository instance.
    }

    //Business Logic
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTaskStatus(Long id, String status) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findTasksByPriority(Integer priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    public List<Task> findTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
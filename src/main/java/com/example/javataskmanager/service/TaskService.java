package com.example.javataskmanager.service;

import com.example.javataskmanager.model.Task;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTaskStatus(Long id, String status);
    void deleteTask(Long id);
    List<Task> findTasksByPriority(Integer priority);
    List<Task> findTasksByStatus(String status);
}
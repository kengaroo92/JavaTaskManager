package com.example.javataskmanager.repository;

import com.example.javataskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Data Access Layer
//Extending JPARepository enables built-in methods.
//save(Task entity)
//findById(Long id)
//findAll()
//deleteById(Long id)

public interface TaskRepository extends JpaRepository<Task, Long> {
    //Stays empty because Spring Data JPA unless I need to add custom query methods.
    //JPA is Java Persistence API.

    //Custom Methods
    List<Task> findByStatus(String status);

    List<Task> findByPriority(Integer priority);
}
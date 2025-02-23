package com.taskapprovalsystem.repository;

import com.taskapprovalsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
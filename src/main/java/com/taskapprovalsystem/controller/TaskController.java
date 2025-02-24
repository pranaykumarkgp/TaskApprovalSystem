package com.taskapprovalsystem.controller;


import com.taskapprovalsystem.entity.Task;
import com.taskapprovalsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {


    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, @RequestParam String emailId) {
        return taskService.createTask(task, emailId);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<String> approveTask(@PathVariable Long id, @RequestParam String approver) {
        taskService.approveTask(id, approver);
        return ResponseEntity.ok("The task has been successfully Approved");
    }
}

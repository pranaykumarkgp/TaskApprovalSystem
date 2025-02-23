package com.taskapprovalsystem.controller;


import com.taskapprovalsystem.entity.Task;
import com.taskapprovalsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/{id}/approve")
    public Task approveTask(@PathVariable Long id, @RequestParam String approver) {
        return taskService.approveTask(id, approver);
    }
}

package com.taskapprovalsystem.service;


import com.taskapprovalsystem.entity.Task;
import com.taskapprovalsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task, String emailId) {

        Task newTask = new Task();

        newTask.setStatus("Pending");
        newTask.setCreatorEmail(emailId);
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());

        return taskRepository.save(task);

    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task approveTask(Long id, String approver) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (!task.addApproval(approver)) {
            throw new IllegalArgumentException("Approver has already approved");
        }
        if (task.getApprovals().size() >= 2) {
            task.setStatus("Approved");
        }
        return taskRepository.save(task);
    }
}

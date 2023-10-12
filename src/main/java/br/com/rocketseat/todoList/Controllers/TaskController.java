package br.com.rocketseat.todoList.Controllers;

import br.com.rocketseat.todoList.Repository.TaskRepository;
import br.com.rocketseat.todoList.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    public TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task dados){
        var task = this.taskRepository.save(dados);
        return ResponseEntity.ok(task);
    }
}

package br.com.rocketseat.todoList.Controllers;

import br.com.rocketseat.todoList.Repository.TaskRepository;
import br.com.rocketseat.todoList.models.Task;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.rocketseat.todoList.Utils.Util;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    public TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody Task dados, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        dados.setIdUser((UUID) idUser);

        var currentDate = LocalDateTime.now();
        if (currentDate.isAfter(dados.getStarting_at()) || currentDate.isAfter(dados.getEnded_at())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body( "A data de inicio ou término deve ser maior do que a atual");
        }

        if ( dados.getStarting_at().isAfter(dados.getEnded_at()) ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body( "A data de inicio  deve ser menor do que a data do término");
        }

        var task = this.taskRepository.save(dados);
        return ResponseEntity.ok(task);
    }
    @GetMapping
    public ResponseEntity<List<Task>> list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIdUser((UUID)idUser);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public Task update(@RequestBody Task dados, @PathVariable UUID id){
        var task = this.taskRepository.findById(id).orElse(null);

        Util.copyNonNullProperties(dados, task);

        return this.taskRepository.save(task);
    }
}

package br.com.rocketseat.todoList.Repository;

import br.com.rocketseat.todoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}

package br.com.rocketseat.todoList.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_task")
public class Task {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String tittle;
    private LocalDateTime starting_at;
    private LocalDate ended_at;
    private String priority;

    private LocalDateTime created_at;

    private UUID idUser;
}

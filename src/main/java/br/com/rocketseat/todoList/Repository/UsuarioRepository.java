package br.com.rocketseat.todoList.Repository;

import br.com.rocketseat.todoList.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByUsername(String username);
}

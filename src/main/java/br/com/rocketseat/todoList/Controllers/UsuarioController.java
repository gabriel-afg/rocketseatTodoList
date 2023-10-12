package br.com.rocketseat.todoList.Controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rocketseat.todoList.Repository.UsuarioRepository;
import br.com.rocketseat.todoList.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/register")
    public ResponseEntity<Usuario> create(@RequestBody Usuario dados) {
        var userAlreadyExist = this.usuarioRepository.findByUsername(dados.getUsername());

        if(userAlreadyExist != null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ja existe");
        }

        var passwordHashed = BCrypt.withDefaults().hashToString(12, dados.getPassword().toCharArray());
        dados.setPassword(passwordHashed);

        var userCreated = usuarioRepository.save(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

}

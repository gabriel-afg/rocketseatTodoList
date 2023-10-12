package br.com.rocketseat.todoList.Filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rocketseat.todoList.Repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        var authorization = request.getHeader("Authorization");
        var authEncoded = authorization.substring("Basic".length()).trim();

        byte[] authDecoded = Base64.getDecoder().decode(authEncoded);

        var authSringDecode= new String(authDecoded);
        String[] credentials = authSringDecode.split(":");
        String username = credentials[0];
        String password = credentials[1];

        var userExist = this.usuarioRepository.findByUsername(username);
        if(userExist == null){
            response.sendError(401);
        }else {
            var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), userExist.getPassword());
            if(passwordVerify.verified){
                filterChain.doFilter(request, response);
            }else {
                response.sendError(401);
            }
        }
    }
}

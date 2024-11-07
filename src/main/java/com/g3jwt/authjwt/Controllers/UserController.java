package com.g3jwt.authjwt.Controllers;

import java.util.List;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3jwt.authjwt.Entities.User;
import com.g3jwt.authjwt.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> userAutenticado(){
        Authentication autenticador = SecurityContextHolder.getContext().getAuthentication();

        User usuarioautenticado = (User) autenticador.getPrincipal();
        
        

        return ResponseEntity.ok(usuarioautenticado);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();

        return ResponseEntity.ok(users);
    }

}

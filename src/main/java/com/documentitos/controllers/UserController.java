package com.documentitos.controllers;

import com.documentitos.models.UserRequest;
import com.documentitos.models.UserResponse;
import com.documentitos.models.usuario;
import com.documentitos.services.AuthService;
import com.documentitos.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api
@RestController
@Slf4j
public class UserController {

    @Autowired
    public UserService userService;
    
        @Autowired
    private AuthService authService;

    @Autowired
//    public EmailService emailService;

    @GetMapping(value = "external/users")
    @ApiOperation(value = "Retorna todos los usuarios registrados en el sistema.")
    public List<usuario> loginUser() {
        return userService.getAllUsers();
    }
    
    @PostMapping("external/users/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {
        boolean isAuthenticated = authService.authenticate(userRequest.getUsuario(), userRequest.getContrasenia());
        if (isAuthenticated) {
            // Genera el token de autenticación y envía una respuesta exitosa
            String token = "token_de_prueba";
            UserResponse response = new UserResponse();
            response.setToken(token);
            response.setMessage("Inicio de sesión exitoso");
            return ResponseEntity.ok(response);
        } else {
            // Retorna una respuesta de error en caso de autenticación fallida
            UserResponse response = new UserResponse();
            response.setMessage("Inicio de sesión fallido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}

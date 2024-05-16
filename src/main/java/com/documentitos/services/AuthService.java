/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.services;

import com.documentitos.models.usuario;
import com.documentitos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yocary
 */
@Service

public class AuthService {
    
        @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String user, String password) {
        usuario usuario = userRepository.findByUser(user);
        if (user == null) {
            return false;
        }

        // Aquí puedes implementar la lógica de autenticación, por ejemplo, verificar la contraseña
        // En este ejemplo, se compara la contraseña en texto plano, lo cual no es seguro en producción
        return usuario.getPassword().equals(password);
    }
    
}

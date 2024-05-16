package com.documentitos.repositories;

import com.documentitos.models.usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<usuario, String> {

    @Override
    List<usuario> findAll();
    
   
   public usuario findByUser(String usuario);
}

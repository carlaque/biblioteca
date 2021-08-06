package com.fatec.biblioteca.repositories;

import com.fatec.biblioteca.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
}

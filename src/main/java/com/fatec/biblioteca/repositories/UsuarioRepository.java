package com.fatec.biblioteca.repositories;

import com.fatec.biblioteca.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

package com.fatec.biblioteca.config.security;

import com.fatec.biblioteca.models.User;
import com.fatec.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(usuarioRepository.findByUsername(username));
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Dados invalidos");
    }
}

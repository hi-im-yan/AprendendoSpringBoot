package com.example.AprendendoSpring.repository;

import com.example.AprendendoSpring.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

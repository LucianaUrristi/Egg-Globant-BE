package com.egg.biblioteca.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.biblioteca.entidades.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID>{
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail(@Param("email") String email);
}

package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Imagen;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, UUID>{

}

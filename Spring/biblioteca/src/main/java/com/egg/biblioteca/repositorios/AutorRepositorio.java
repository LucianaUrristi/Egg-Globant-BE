
package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Autor;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, UUID> {

}

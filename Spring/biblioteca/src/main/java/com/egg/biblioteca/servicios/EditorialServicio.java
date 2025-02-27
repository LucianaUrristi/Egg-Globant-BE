package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.EditorialRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiException{
        
        validar(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        
        List<Editorial> editoriales = new ArrayList<>();


        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }
    
    @Transactional
    public void modificarEditorial(UUID id, String nombre) throws MiException{
        validar(nombre);

        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        } else {
            throw new MiException("No se encontró una editorial con el ID especificado");
        }
    }
    
    @Transactional
    public void eliminar(UUID id) throws MiException{
        Optional<Editorial> editorialOpt = editorialRepositorio.findById(id);
        if (editorialOpt.isPresent()) {
            editorialRepositorio.delete(editorialOpt.get());
        } else {
            throw new MiException("La editorial con el ID especificado no existe");
        }
    }

    private void validar(String nombre) throws MiException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MiException("El nombre de la editorial no puede ser nulo o estar vacío");
        }
    }
}

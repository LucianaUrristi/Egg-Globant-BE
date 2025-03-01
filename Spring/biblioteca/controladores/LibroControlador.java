package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.excepciones.MiException;
// import com.egg.biblioteca.servicios.AutorServicio;
// import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;

import java.util.UUID;


@Controller
@RequestMapping("/libro") // localhost:8080/libro
public class LibroControlador {
    
    @Autowired
    private LibroServicio libroServicio;
    // @Autowired
    // private AutorServicio autorServicio;
    // @Autowired
    // private EditorialServicio editorialServicio;

    @GetMapping("/registrar") //localhost:8080/libro/registrar
    public String registrar(ModelMap modelo) {
        
        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo, 
                            @RequestParam(required = false) Integer ejemplares, 
                            @RequestParam String idAutor,
                            @RequestParam String idEditorial, ModelMap modelo) {
        try {
            // Realizamos la conversión manual de String a UUID. En este caso, se convertirá solo si el ID no es nulo y no está vacío
            UUID autorUUID = (idAutor != null && !idAutor.isEmpty()) ? UUID.fromString(idAutor) : null;
            UUID editorialUUID = (idEditorial != null && !idEditorial.isEmpty()) ? UUID.fromString(idEditorial) : null;

            libroServicio.crearLibro(isbn, titulo, ejemplares, autorUUID, editorialUUID);
            modelo.put("exito", "El libro fue cargado correctamente.");
            

        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());

            return "libro_form.html"; // volvemos a cargar el formulario.
        }
        return "index.html";
    }
}


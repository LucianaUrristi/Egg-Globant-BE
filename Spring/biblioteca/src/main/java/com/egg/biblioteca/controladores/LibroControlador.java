package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;

import java.util.UUID;


@Controller
@RequestMapping("/libro") // localhost:8080/libro
public class LibroControlador {
    
    @Autowired
    private LibroServicio libroServicio;
    @Autowired
    private AutorServicio autorServicio;
    @Autowired
    private EditorialServicio editorialServicio;
    

    @GetMapping("/registrar") //localhost:8080/libro/registrar
    public String registrar(ModelMap model) {
        // Manera simplificada de hacer:
        // List<Autor> autores = autorServicio.listarAutores();
        // List<Editorial> editoriales = editorialServicio.listarEditoriales();
        // model.addAttribute("autores", autores);
        // model.addAttribute("editoriales", editoriales);
    
        model.addAttribute("autores", autorServicio.listarAutores());
        model.addAttribute("editoriales", editorialServicio.listarEditoriales());
        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo, 
                            @RequestParam(required = false) Integer ejemplares, 
                            @RequestParam String idAutor,
                            @RequestParam String idEditorial, ModelMap model) {
        try {
            // Realizamos la conversión manual de String a UUID. En este caso, se convertirá solo si el ID no es nulo y no está vacío
            UUID autorUUID = (idAutor != null && !idAutor.isEmpty()) ? UUID.fromString(idAutor) : null;
            UUID editorialUUID = (idEditorial != null && !idEditorial.isEmpty()) ? UUID.fromString(idEditorial) : null;

            if (autorUUID == null || editorialUUID == null) {
                throw new MiException("Debe seleccionar un autor y una editorial válidos.");
            }

            libroServicio.crearLibro(isbn, titulo, ejemplares, autorUUID, editorialUUID);
            model.put("exito", "El libro fue cargado correctamente.");
            

        } catch (MiException ex) {
            model.addAttribute("autores", autorServicio.listarAutores());
            model.addAttribute("editoriales", editorialServicio.listarEditoriales());
            model.put("error", ex.getMessage());

            return "libro_form.html"; // volvemos a cargar el formulario.
        }
        return "inicio.html";
    }
    
    @GetMapping("lista")
    public String listar(ModelMap model) {
        // List<Libro> libros = libroServicio.listarLibros();
        // model.addAttribute("libros", libros);
    
        model.addAttribute("libros", libroServicio.listarLibros()); //es lo mismo pero en una sola línea
        return "libro_list.html";
    }

    @GetMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn, ModelMap model) {
        Libro libro = libroServicio.getOne(isbn);

        model.put("libro", libroServicio.getOne(isbn));
        model.addAttribute("autores", autorServicio.listarAutores());  // Agregar autores para que nos muestre la lista de autores
        model.addAttribute("editoriales", editorialServicio.listarEditoriales());  // Agregar editoriales para que nos muestre la lista de autores

        model.addAttribute("autorSeleccionado", libro.getAutor().getId());  // UUID del autor actual para que ya aparezca seleccionado
        model.addAttribute("editorialSeleccionada", libro.getEditorial().getId());  // UUID de la editorial actual para que ya aparezca seleccionado
        return "libro_modificar.html";
    }

    @PostMapping("/modificar/{isbn}")
    public String modificar(@PathVariable @RequestParam(required = false) Long isbn, @RequestParam String titulo, 
    @RequestParam(required = false) Integer ejemplares, @RequestParam String idAutor, @RequestParam String idEditorial, ModelMap model) {
        try {
            UUID autorUUID = (idAutor != null && !idAutor.isEmpty()) ? UUID.fromString(idAutor) : null;
            UUID editorialUUID = (idEditorial != null && !idEditorial.isEmpty()) ? UUID.fromString(idEditorial) : null;

            if (autorUUID == null || editorialUUID == null) {
                throw new MiException("Debe seleccionar un autor y una editorial válidos.");
            }

            libroServicio.modificarLibro(isbn, titulo, ejemplares, autorUUID, editorialUUID);
            return "redirect:../lista";

        } catch (MiException ex) {
            model.addAttribute("autores", autorServicio.listarAutores());
            model.addAttribute("editoriales", editorialServicio.listarEditoriales());
            model.put("error", ex.getMessage());
            return "libro_modificar.html";
        }
    }
}


package com.egg.biblioteca.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.EditorialServicio;
// import java.util.logging.Level;
// import java.util.logging.Logger;


@Controller
@RequestMapping("/editorial") // localhost:8080/editorial
public class EditorialControlador {
    
    @Autowired 
    private EditorialServicio editorialServicio;

    @GetMapping("/registrar") // localhost:8080/editorial/registrar
    public String registrar() {
        return "editorial_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo){
        try {
            editorialServicio.crearEditorial(nombre);    // llamo a mi servicio para persistir 
            modelo.put("exito", "La editorial fue cargada correctamente.");       
        } catch (MiException ex) {          
            modelo.put("error", ex.getMessage());
            // Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "editorial_form.html";
        }        
        return "index.html";
    
    }
}


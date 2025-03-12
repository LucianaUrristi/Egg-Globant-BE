package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class PortalControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")  // Acá es donde realizamos el mapeo
    public String index() {
        return "index.html";   // Acá es que retornamos con el método. 
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
                            @RequestParam String password2, ModelMap model) {
        try{
            usuarioServicio.registrar(nombre, email, password, password2);
            model.put("exito", "El usuario fue creado correctamente.");
            return "index.html";

        }catch (MiException ex){
            model.put("error", ex.getMessage());
            model.put("nombre", nombre);
            model.put("email", email);
            return "registro.html"; // Retornamos al formulario de registro con el mensaje de error.
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o Contraseña inválidos!");
        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");

        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }

        return "inicio.html";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login.html";
    }
    
}



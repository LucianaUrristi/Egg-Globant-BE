package com.egg.biblioteca.controladores;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.servicios.UsuarioServicio;


@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/dashboard")
    public String panelAdministrativo(){
        return "panel.html";
    }

    @GetMapping("/usuarios")
    public String listar(ModelMap modelo){
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("usuarios", usuarios);

        return "usuario_list.html";
    }

    @GetMapping("/modificarRol/{id}")
    public String cambiarRol(@PathVariable UUID id){
        usuarioServicio.cambiarRol(id);
        return "redirect:/admin/usuarios";
    }

    
}

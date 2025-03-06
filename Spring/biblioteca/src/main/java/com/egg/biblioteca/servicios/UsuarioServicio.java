package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException {

        validar(nombre, email, password, password2);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setRol(Rol.USER);
        

        usuarioRepositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioRepositorio.findAll();
        return usuarios;
    }

    @Transactional
    public void modificarLibro(String nombre, String email, String password, String password2) throws MiException {

        validar(nombre, email, password, password2);

        Optional<Usuario> respuesta = Optional.ofNullable(usuarioRepositorio.buscarPorEmail(email));
        

        if (respuesta.isEmpty()) {
            throw new MiException("El usuario especificado no existe.");
        }

        Usuario usuario = respuesta.get();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));

        usuarioRepositorio.save(usuario);
    }


    private void validar(String nombre, String email, String password, String password2) throws MiException {


        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacío");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }
    
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList<>();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+ usuario.getRol().toString());

            permisos.add(p);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        }else{
            return null;
        }
}


}

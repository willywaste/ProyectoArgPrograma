package com.portfoliogdv.gdv.Security.Controller;

import com.portfoliogdv.gdv.Security.Entity.Usuario;
import com.portfoliogdv.gdv.Security.Jwt.JwtProvider;
import com.portfoliogdv.gdv.Security.Service.RolService;
import com.portfoliogdv.gdv.Security.Service.UsuarioService;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin

public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;


    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o Email Invalido"),HttpStatus.BAD_REQUEST);

        if(usuarioService.existsByNombreUsuario(nombreUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Nombre de usuario ya existe"),HttpStatus.BAD_REQUEST);

        if(usuarioService.existsByEmail(nombreUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email ya existe"),HttpStatus.BAD_REQUEST);


        Usuario usuario = new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
    }
}

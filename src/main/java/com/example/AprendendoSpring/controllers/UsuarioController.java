package com.example.AprendendoSpring.controllers;

import com.example.AprendendoSpring.models.Usuario;
import com.example.AprendendoSpring.services.AuthService;
import com.example.AprendendoSpring.services.UsuarioService;
import com.example.AprendendoSpring.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private AuthUtil auth;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Usuario usuario, HttpServletRequest request){

        String basicAuth = request.getHeader("Authorization");

        if (auth.validaUsuario(basicAuth))
            service.cadastrar(usuario);
    }

    @PutMapping("/atualizar")
    public void atualizar(@RequestBody Map<String, String> payload, HttpServletRequest request){

        String basicAuth = request.getHeader("Authorization");
        if (auth.validaUsuario(basicAuth))
            service.atualizar(payload);
    }
}

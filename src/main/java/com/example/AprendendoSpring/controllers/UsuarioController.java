package com.example.AprendendoSpring.controllers;

import com.example.AprendendoSpring.models.Usuario;
import com.example.AprendendoSpring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Usuario usuario){
        service.cadastrar(usuario);
    }

    @PutMapping("/atualizar")
    public void atualizar(@RequestBody Map<String, String> payload){
        service.atualizar(payload);
    }
}

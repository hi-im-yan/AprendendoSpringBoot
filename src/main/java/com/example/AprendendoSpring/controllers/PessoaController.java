package com.example.AprendendoSpring.controllers;

import com.example.AprendendoSpring.models.Pessoa;
import com.example.AprendendoSpring.services.AuthService;
import com.example.AprendendoSpring.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpHeaders;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @Autowired
    private AuthService auth;

    @GetMapping("/buscarTodos")
    public List<Pessoa> buscarTodos(HttpServletRequest request){
        String basicAuth = request.getHeader("Authorization");
        if(basicAuth.isEmpty()) {
            return Collections.emptyList();
        }

        auth.validaBasicAuth(basicAuth);
        return service.getAllPessoas();
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable(value="id") Long id){
        return service.getPessoa(id);
    }

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Pessoa pessoa){
        service.cadastrar(pessoa);
    }

    @DeleteMapping("/deletar")
    public void deletar(@RequestBody Map<String,String> payload){
        service.deletar(Long.valueOf(payload.get("id")));
    }

    @DeleteMapping("/deletarTodos")
    public void deletar(){
        service.deletarTodos();
    }

    @PutMapping("/atualizar")
    public void atualizar(@RequestBody Map<String,String> payload) throws ParseException {
        service.atualizar(payload);
    }

    @GetMapping("/help")
    public Map<String, String> ajuda(){
        Map<String, String> ajuda = new HashMap<>();
        ajuda.put("/buscarTodos", "/");
        ajuda.put("/buscarPorId", "/{id}");
        ajuda.put("/cadastrar", "payload -> nome, sexo, email, naturalidade, nacionalidade, cpf, data_nascimento (dd/mm/yyyy)");
        ajuda.put("/deletar", "payload -> id");
        ajuda.put("/deletarTodos","/");
        ajuda.put("/atualizar", "payload -> id, dados para atualizar");
        return ajuda;
    }


}

package com.example.AprendendoSpring.services;

import com.example.AprendendoSpring.models.Pessoa;
import com.example.AprendendoSpring.models.Usuario;
import com.example.AprendendoSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void cadastrar(Usuario usuario){
        repository.saveAndFlush(usuario);
    }


    public void atualizar(Map<String, String> payload){
        Long id = Long.valueOf(payload.get("id"));
        Usuario usuario = repository.getById(id);

        for(Map.Entry<String, String> entry: payload.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            switch(key){
                case "login": usuario.setLogin(value);
                    break;
                case "senha": usuario.setSenha(value);
                    break;
                case "id": break;
                default:
                    System.out.println("Coluna " + key + " não existe");
                    break;
            }
        }

        repository.saveAndFlush(usuario);
    }

}

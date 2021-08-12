package com.example.AprendendoSpring.services;

import com.example.AprendendoSpring.models.Usuario;
import com.example.AprendendoSpring.repository.UsuarioRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String[] validaBasicAuth(String basicAuth){
        byte[] dec64 = Base64.decodeBase64(basicAuth.replace("Basic ", ""));
        String dec = new String(dec64);
        String[] usuarioSenha = dec.split(":");

        return usuarioSenha;
    }

    public boolean autentica(String login, String senha){
        Usuario usuario = usuarioRepository.findUsuarioByLoginAndSenha(login, senha);

        return usuario != null;
    }


}

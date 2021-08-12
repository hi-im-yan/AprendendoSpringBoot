package com.example.AprendendoSpring.utils;

import com.example.AprendendoSpring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUtil {

    @Autowired
    private AuthService auth;

    public Boolean validaUsuario(String basicAuth){

        if(!basicAuth.isEmpty()){
            String [] usuarioSenha = auth.validaBasicAuth(basicAuth);
            return auth.autentica(usuarioSenha[0], usuarioSenha[1]);
        }

        return false;
    }
}

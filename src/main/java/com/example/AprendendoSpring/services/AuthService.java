package com.example.AprendendoSpring.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public void validaBasicAuth(String basicAuth){
        byte[] dec64 = Base64.decodeBase64(basicAuth.replace("Basic ", ""));
        String dec = new String(dec64);
        String[] re = dec.split(":");

        String userName = re[0];
        String password = re[1];

        System.out.println(userName + " - " + password);
    }


}

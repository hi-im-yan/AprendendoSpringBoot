package com.example.AprendendoSpring.controllers;

import com.example.AprendendoSpring.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthUtil auth;


    @PostMapping("/login")
    public String login(HttpServletRequest request){
        String basicAuth = request.getHeader("FirstAuth");
        if (auth.validaUsuario(basicAuth))
            return basicAuth;
        return "Unauthorized";
    }

    @GetMapping("/auth")
    public String auth(HttpServletRequest request){
        String basicAuth = request.getHeader("Authorization");
        try{
            if (auth.validaUsuario(basicAuth))
                return "Authorized";
        }
        catch(Exception e){
            return "Unauthorized";
        }
        return "Unauthorized";
    }
}

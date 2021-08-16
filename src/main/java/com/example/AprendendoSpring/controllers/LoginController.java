package com.example.AprendendoSpring.controllers;

import com.example.AprendendoSpring.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthUtil auth;


    @PostMapping("/login")
    public String login(HttpServletRequest request){
        String basicAuth = request.getHeader("FirstAuth");
        if (auth.validaUsuario(basicAuth))
            return basicAuth;
        return "Unauthorized";
    }
}

package com.example.AprendendoSpring.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    private Date data_inclusao, data_atualizacao;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @PrePersist
    protected void onCreate() {
        this.data_inclusao = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.data_atualizacao = new Date();
    }
}

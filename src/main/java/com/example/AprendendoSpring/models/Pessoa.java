package com.example.AprendendoSpring.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome, sexo, email, naturalidade, nacionalidade;
    private Date data_inclusao, data_atualizacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date data_nascimento;

    @NotNull
    @Column(unique=true)
    private String cpf;

    protected Pessoa() {}

    public Pessoa(String nome, String sexo, String email, String naturalidade, String nacionalidade, String cpf, Date data_nascimento, Date data_inclusao) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.naturalidade = naturalidade;
        this.nacionalidade = nacionalidade;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.data_inclusao = data_inclusao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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

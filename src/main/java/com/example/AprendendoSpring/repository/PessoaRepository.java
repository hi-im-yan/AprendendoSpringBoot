package com.example.AprendendoSpring.repository;

import com.example.AprendendoSpring.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    Pessoa findPessoaById(Long id);
}


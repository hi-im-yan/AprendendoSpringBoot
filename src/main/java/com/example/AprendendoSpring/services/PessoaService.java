package com.example.AprendendoSpring.services;

import com.example.AprendendoSpring.models.Pessoa;
import com.example.AprendendoSpring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");


    public PessoaService() {
    }

    public List<Pessoa> getAllPessoas(){
        return repository.findAll();
    }

    public Pessoa getPessoa(Long id){
        return repository.findPessoaById(id);
    }

    public void cadastrar(Pessoa pessoa){
        repository.saveAndFlush(pessoa);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
    public void deletarTodos(){
        repository.deleteAll();
    }

    public void atualizar(Map<String, String> payload) throws ParseException {
        Long id = Long.valueOf(payload.get("id"));
        Pessoa pessoa = repository.findPessoaById(id);

        for(Map.Entry<String, String> entry: payload.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            switch(key){
                case "nome": pessoa.setNome(value);
                    break;
                case "sexo": pessoa.setSexo(value);
                    break;
                case "email": pessoa.setEmail(value);
                    break;
                case "naturalidade": pessoa.setNaturalidade(value);
                    break;
                case "nacionalidade": pessoa.setNacionalidade(value);
                    break;
                case "cpf": pessoa.setCpf(value);
                    break;
                case "data_nascimento": pessoa.setData_nascimento(DATE_FORMAT.parse(value));
                    break;
                case "id": break;
                default:
                    System.out.println("Coluna " + key + " não existe");
                    break;
            }
        }

        repository.saveAndFlush(pessoa);
    }
}

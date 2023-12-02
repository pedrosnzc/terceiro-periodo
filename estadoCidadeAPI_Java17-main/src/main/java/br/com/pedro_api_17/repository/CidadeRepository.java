package br.com.pedro_api_17.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedro_api_17.model.Cidade;

@Repository
public abstract class CidadeRepository implements JpaRepository<Cidade, Long> {

    
    public abstract List<Cidade> findByNomeAndAtivo(String nome, Boolean status);
}

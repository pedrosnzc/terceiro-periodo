package br.com.pedro_api_17.controller;

import br.com.pedro_api_17.model.Cidade;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class CidadeService {
    public Cidade salvar(Cidade cidade) {
        return null;
    }

    public void salvarVarios(List<Cidade> cidades) {
    }

    public List<Cidade> buscarTodos() {
        return null;
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return Optional.empty();
    }

    public ResponseEntity<?> deleteById(Long id) {

        return ResponseEntity.ok().build();
    }
}

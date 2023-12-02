package br.com.pedro_api_17.controller;

import br.com.pedro_api_17.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // disponível a todos
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    /**
     * Salva uma cidade.
     * @param cidade Objeto Cidade a ser salvo.
     * @return ResponseEntity<Cidade> Cidade salva.
     */
    @PostMapping("/saveCidade")
    public ResponseEntity<Cidade> salvarCidade(@RequestBody Cidade cidade) {
        Cidade response = cidadeService.salvar(cidade);
        return ResponseEntity.ok(response);
    }

    /**
     * Salva várias cidades.
     * @param cidades Lista de objetos Cidade a serem salvos.
     * @return ResponseEntity<Void>
     */
    @PostMapping("/saveVarios")
    public ResponseEntity<Void> salvarVarios(@RequestBody List<Cidade> cidades) {
        cidadeService.salvarVarios(cidades);
        return ResponseEntity.ok().build();
    }

    /**
     * Retorna todas as cidades.
     * @return ResponseEntity<List<Cidade>> Lista de cidades.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Cidade>> buscarTodos() {
        List<Cidade> response = cidadeService.buscarTodos();
        return ResponseEntity.ok(response);
    }

    /**
     * Atualiza uma cidade.
     * @param cidade Objeto Cidade a ser atualizado.
     * @return ResponseEntity<Cidade> Cidade atualizada.
     */
    @PutMapping
    public ResponseEntity<Cidade> update(@RequestBody Cidade cidade) {
        if (!cidadeService.buscarPorId(cidade.getId()).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cidadeService.salvar(cidade));
    }

    /**
     * Exclui uma cidade pelo ID.
     * @param id ID da cidade a ser excluída.
     * @return ResponseEntity<?> Resposta da exclusão.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return cidadeService.deleteById(id);
    }
}

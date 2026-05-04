package com.example.api_lojas.controller;

import com.example.api_lojas.model.Loja;
import com.example.api_lojas.repository.LojaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    private final LojaRepository lojaRepository;

    public LojaController(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    // GET /lojas - buscar todas as lojas
    @GetMapping
    public ResponseEntity<List<Loja>> findAll() {
        List<Loja> lojas = lojaRepository.findAll();
        return ResponseEntity.ok(lojas);
    }

    // GET /lojas/{id} - buscar loja por ID
    @GetMapping("/{id}")
    public ResponseEntity<Loja> findById(@PathVariable Long id) {
        Optional<Loja> loja = lojaRepository.findById(id);
        return loja
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /lojas - criar nova loja
    @PostMapping
    public ResponseEntity<Loja> create(@RequestBody Loja loja) {
        Loja salva = lojaRepository.save(loja);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // PUT /lojas/{id} - atualizar loja existente
    @PutMapping("/{id}")
    public ResponseEntity<Loja> update(@PathVariable Long id, @RequestBody Loja lojaAtualizada) {
        Optional<Loja> lojaExistente = lojaRepository.findById(id);
        if (lojaExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        lojaAtualizada.setId(id);
        Loja salva = lojaRepository.save(lojaAtualizada);
        return ResponseEntity.ok(salva);
    }

    // DELETE /lojas/{id} - deletar loja
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!lojaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lojaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

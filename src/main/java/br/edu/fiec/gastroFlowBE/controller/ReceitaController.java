package br.edu.fiec.gastroFlowBE.controller;

import br.edu.fiec.gastroFlowBE.model.dto.ReceitaDTO;
import br.edu.fiec.gastroFlowBE.service.ReceitaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
@AllArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;

    // Criar uma receita
    @PostMapping
    public ResponseEntity<String> createReceita(@RequestBody ReceitaDTO receitaDTO) {
        receitaService.createReceita(receitaDTO);
        return ResponseEntity.ok("Receita cadastrada com sucesso!");
    }

    // Buscar receita por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> getById(@PathVariable Long id) {
        ReceitaDTO receita = receitaService.getById(id);
        if (receita == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(receita);
    }

    // Listar todas as receitas
    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> findAll() {
        return ResponseEntity.ok(receitaService.findAll());
    }

    // Atualizar receita
    @PutMapping("/{id}")
    public ResponseEntity<String> updateReceitaById(@PathVariable Long id, @RequestBody ReceitaDTO receitaDTO) {
        boolean updated = receitaService.updateReceitaById(id, receitaDTO);
        if (updated) {
            return ResponseEntity.ok("Receita atualizada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar receita
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReceitaById(@PathVariable Long id) {
        receitaService.deleteReceitaById(id);
        return ResponseEntity.ok("Receita deletada com sucesso!");
    }
}

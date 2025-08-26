package br.edu.fiec.gastroFlowBE.service;

import br.edu.fiec.gastroFlowBE.model.dto.ReceitaDTO;
import br.edu.fiec.gastroFlowBE.model.entity.Produto;
import br.edu.fiec.gastroFlowBE.model.entity.Receita;
import br.edu.fiec.gastroFlowBE.repository.ProdutoRepository;
import br.edu.fiec.gastroFlowBE.repository.ReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;
    private final ProdutoRepository produtoRepository;

    // Criar Receita
    public void createReceita(ReceitaDTO receitaDTO) {
        Receita receita = new Receita();
        receita.setNome(receitaDTO.getNome());
        receita.setDescricao(receitaDTO.getDescricao());
        receita.setTempoPreparo(receitaDTO.getTempoPreparo());
        receita.setTextoPreparo(receitaDTO.getTextoPreparo());

        // Busca os produtos existentes pelo ID
        List<Produto> produtos = produtoRepository.findAllById(receitaDTO.getProdutoIds());
        receita.setProdutos(produtos);

        receitaRepository.save(receita);
    }

    // Buscar receita por ID
    public ReceitaDTO getById(Long id) {
        return receitaRepository.findById(id).map(receita -> {
            ReceitaDTO dto = new ReceitaDTO();
            dto.setNome(receita.getNome());
            dto.setDescricao(receita.getDescricao());
            dto.setTempoPreparo(receita.getTempoPreparo());
            dto.setTextoPreparo(receita.getTextoPreparo());

            // retorna apenas os IDs dos produtos
            dto.setProdutoIds(
                    receita.getProdutos().stream().map(Produto::getId).toList()
            );

            return dto;
        }).orElse(null);
    }

    // Listar todas as receitas
    public List<ReceitaDTO> findAll() {
        return receitaRepository.findAll().stream().map(receita -> {
            ReceitaDTO dto = new ReceitaDTO();
            dto.setNome(receita.getNome());
            dto.setDescricao(receita.getDescricao());
            dto.setTempoPreparo(receita.getTempoPreparo());
            dto.setTextoPreparo(receita.getTextoPreparo());
            dto.setProdutoIds(
                    receita.getProdutos().stream().map(Produto::getId).toList()
            );
            return dto;
        }).toList();
    }

    // Atualizar receita por ID
    public boolean updateReceitaById(Long id, ReceitaDTO receitaDTO) {
        return receitaRepository.findById(id).map(receita -> {
            receita.setNome(receitaDTO.getNome());
            receita.setDescricao(receitaDTO.getDescricao());
            receita.setTempoPreparo(receitaDTO.getTempoPreparo());
            receita.setTextoPreparo(receitaDTO.getTextoPreparo());

            if (receitaDTO.getProdutoIds() != null) {
                List<Produto> produtos = produtoRepository.findAllById(receitaDTO.getProdutoIds());
                receita.setProdutos(produtos);
            }

            receitaRepository.save(receita);
            return true;
        }).orElse(false);
    }

    // Deletar receita
    public void deleteReceitaById(Long id) {
        receitaRepository.deleteById(id);
    }
}
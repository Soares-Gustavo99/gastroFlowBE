package br.edu.fiec.gastroFlowBE.service;

import br.edu.fiec.gastroFlowBE.model.dto.ProdutoDTO;
import br.edu.fiec.gastroFlowBE.model.entity.Produto;
import br.edu.fiec.gastroFlowBE.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private List<ProdutoDTO> produtoDTOList;

    public void createProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(
                produtoDTO.getNome(),
                produtoDTO.getCategoria(),
                produtoDTO.getQuantidadeEstoque(),
                produtoDTO.getUnidadeMedida(),
                produtoDTO.getValidade());

        produtoRepository.save(produto);
    }

    public ProdutoDTO getById(Integer id) {
        return produtoRepository.findById(id).map(produto -> new ProdutoDTO(
                produto.getNome(),
                produto.getCategoria(),
                produto.getQuantidadeEstoque(),
                produto.getUnidadeMedida(),
                produto.getValidade()
        )).orElse(null);
    }


    //PRECISA SER CORRIGIDO PARA RETORNAR UM OBJETO. DEPOIS EU VEJO ISSO
    public List<ProdutoDTO> getAllByNome(String nome) {
        List<ProdutoDTO> produtoDTOList = new ArrayList<>();

        Optional<Produto> produtos = produtoRepository.findByNome(nome);
                produtoDTOList.forEach(produto ->
                        produtoDTOList.add(new ProdutoDTO(
                                produto.getNome(),
                                produto.getCategoria(),
                                produto.getQuantidadeEstoque(),
                                produto.getUnidadeMedida(),
                                produto.getValidade()
                        ))
        );

        return produtoDTOList;
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream()
                .map(produto -> new ProdutoDTO(
                        produto.getNome(),
                        produto.getCategoria(),
                        produto.getQuantidadeEstoque(),
                        produto.getUnidadeMedida(),
                        produto.getValidade()
                        ))
                .toList();
    }

    public boolean updateProdutoById(Integer id, ProdutoDTO produtoDTO) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoDTO.getNome());
                    produto.setCategoria(produtoDTO.getCategoria());
                    produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
                    produto.setUnidadeMedida(produtoDTO.getUnidadeMedida());
                    produto.setValidade(produtoDTO.getValidade());

                    produtoRepository.save(produto);
                    return true;
                })
                .orElse(false);
    }

    public void deleteProdutoById(Integer id){
        produtoRepository.deleteById(id);
    }

    public List<ProdutoDTO> getAll(){
        return this.produtoDTOList;
    }
}


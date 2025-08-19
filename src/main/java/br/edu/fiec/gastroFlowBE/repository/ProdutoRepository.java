package br.edu.fiec.gastroFlowBE.repository;

import br.edu.fiec.gastroFlowBE.model.dto.ProdutoDTO;
import br.edu.fiec.gastroFlowBE.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome);
}

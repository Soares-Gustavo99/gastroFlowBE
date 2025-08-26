package br.edu.fiec.gastroFlowBE.repository;

import br.edu.fiec.gastroFlowBE.model.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {}


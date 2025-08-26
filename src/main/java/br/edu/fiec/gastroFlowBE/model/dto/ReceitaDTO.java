package br.edu.fiec.gastroFlowBE.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaDTO {

    private String nome;

    private String descricao;

    private String tempoPreparo;

    private String textoPreparo;

    private List<Long> produtoIds; // apenas IDs, relacão N:N
}

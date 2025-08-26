package br.edu.fiec.gastroFlowBE.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String nome;

    private String categoria;

    private Integer quantidadeEstoque;

    private String unidadeMedida;

    private Date validade;

}

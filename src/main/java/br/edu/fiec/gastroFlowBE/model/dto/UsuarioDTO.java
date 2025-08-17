package br.edu.fiec.gastroFlowBE.model.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String nome;

    private String email;

    private String nivel_acesso;

    private String senha;

}

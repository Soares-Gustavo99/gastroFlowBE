package br.edu.fiec.gastroFlowBE.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_usuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nivel_acesso;

    @Column(nullable = false)
    private String senha;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date data_cadastro;


    public Usuario(String nome, String email, String nivelAcesso, String senha) {
        this.nome = nome;
        this.email = email;
        this.nivel_acesso = nivelAcesso;
        this.senha = senha;
    }
}

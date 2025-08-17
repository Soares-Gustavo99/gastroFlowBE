package br.edu.fiec.gastroFlowBE.service;

import br.edu.fiec.gastroFlowBE.model.dto.UsuarioDTO;
import br.edu.fiec.gastroFlowBE.model.entity.Usuario;
import br.edu.fiec.gastroFlowBE.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final List<UsuarioDTO> usuarioList = new ArrayList<>();

    public void createUsuario(UsuarioDTO usuarioDTO){

        //Lógica para verificar se já existe um usuário com esse e-mail
        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("E-mail já está em uso.");
        }
        Usuario usuario = new Usuario(
                usuarioDTO.getNome(),
                usuarioDTO.getEmail(),
                usuarioDTO.getNivel_acesso(),
                usuarioDTO.getSenha());

        usuarioRepository.save(usuario);
    }

    // Metodo para retornar o usuario pelo id especifico
    public UsuarioDTO getById(Integer id){
        return usuarioRepository.findById(id).map(value ->
                new UsuarioDTO(
                        value.getNome(),
                        value.getEmail(),
                        value.getNivel_acesso(),
                        value.getSenha()
                )
        ).orElse(null);
    }

    // Metodo para retorar os usuarios
    public List<UsuarioDTO> findAll(){
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getNivel_acesso(),
                        usuario.getSenha()))
                .toList();
    }

    //Metodo para alterar algum usuario
    public boolean updateUsuarioById(Integer id, UsuarioDTO usuarioDTO){
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(usuarioDTO.getNome());
            usuario.setSenha(usuarioDTO.getSenha());
            usuario.setNivel_acesso(usuarioDTO.getNivel_acesso());

            usuarioRepository.save(usuario);
            return true;
        }).orElse(false);
    }

    //Metodo para deletar um usuario
    public void deleteUsuarioById(Integer id){
        usuarioRepository.deleteById(id);
    }
}

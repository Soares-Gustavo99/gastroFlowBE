package br.edu.fiec.gastroFlowBE.controller;


import br.edu.fiec.gastroFlowBE.model.dto.UsuarioDTO;
import br.edu.fiec.gastroFlowBE.model.entity.Usuario;
import br.edu.fiec.gastroFlowBE.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // ********** METODOS POST ************

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.createUsuario(usuarioDTO);
    }


    // ********** METODOS GET ************


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public UsuarioDTO getById(@RequestParam Integer id){
        return usuarioService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public UsuarioDTO getByEmail(@RequestParam String email){
        return usuarioService.getByEmail(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "usuarios", produces = APPLICATION_JSON_VALUE)
    public List<UsuarioDTO> findALl(){
        return usuarioService.findAll();
    }


    // ********** METODOS PATCH ************


    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(consumes= APPLICATION_JSON_VALUE)
    public void updateUsuarioById(@RequestParam Integer id, @RequestBody UsuarioDTO usuarioDTO){
        usuarioService.updateUsuarioById(id, usuarioDTO);
    }

    // ********** METODOS DELETE ************


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping()
    public void deleteUsuarioById(@RequestParam Integer id) {
        usuarioService.deleteUsuarioById(id);
    }

}

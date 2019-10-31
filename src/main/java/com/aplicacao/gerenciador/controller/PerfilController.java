package com.aplicacao.gerenciador.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.gerenciador.exception.ResourceNotFoundException;
import com.aplicacao.gerenciador.model.Perfil;
import com.aplicacao.gerenciador.repository.PerfilRepository;



@RestController
@RequestMapping("/api/v1")
public class PerfilController {
	 
    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping("/perfis")
    public List < Perfil > getTodosPerfis() {
        return perfilRepository.findAll();
    }

    @GetMapping("/perfis/{id}")
    public ResponseEntity < Perfil > getPerfilById(@PathVariable(value = "id") Long perfilId)
    throws ResourceNotFoundException {
        Perfil perfil = perfilRepository.findById(perfilId)
            .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado para o id :: " + perfilId));
		return ResponseEntity.ok().body(perfil);
    }
    
  
    @PostMapping("/perfis")
    public Perfil createPerfil(@Valid @RequestBody Perfil perfil) throws ResourceNotFoundException {
    	return perfilRepository.save(perfil);          
    }

 

    @DeleteMapping("/perfil/{id}")
    public Map < String, Boolean > deletePerfil(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Perfil perfil = perfilRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado id :: " + id));

        perfilRepository.delete(perfil);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

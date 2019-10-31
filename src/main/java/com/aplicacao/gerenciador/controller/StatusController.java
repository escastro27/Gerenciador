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
import com.aplicacao.gerenciador.model.Status;
import com.aplicacao.gerenciador.repository.StatusRepository;



@RestController
@RequestMapping("/api/v1")
public class StatusController {
	 
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/status")
    public List < Status > getTodosStatus() {
        return statusRepository.findAll();
    }

    @GetMapping("/status/{id}")
    public ResponseEntity < Status > getStatusById(@PathVariable(value = "id") Long statusId)
    throws ResourceNotFoundException {
    	Status status = statusRepository.findById(statusId)
            .orElseThrow(() -> new ResourceNotFoundException("Status não encontrado para o id :: " + statusId));
		return ResponseEntity.ok().body(status);
    }
    
  
    @PostMapping("/status")
    public Status createStatus(@Valid @RequestBody Status status) throws ResourceNotFoundException {
    	return statusRepository.save(status);          
    }

 

    @DeleteMapping("/status/{id}")
    public Map < String, Boolean > deleteStatus(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
    	Status status = statusRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Status não encontrado com id :: " + id));

        statusRepository.delete(status);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

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
import com.aplicacao.gerenciador.model.Cargo;
import com.aplicacao.gerenciador.repository.CargoRepository;



@RestController
@RequestMapping("/api/v1")
public class CargoController {
	 
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/cargos")
    public List < Cargo > getTodoscargos() {
        return cargoRepository.findAll();
    }

    @GetMapping("/cargos/{id}")
    public ResponseEntity < Cargo > getCargoById(@PathVariable(value = "id") Long cargoId)
    throws ResourceNotFoundException {
        Cargo cargo = cargoRepository.findById(cargoId)
            .orElseThrow(() -> new ResourceNotFoundException("Cargo não encontrado para o id :: " + cargoId));
		return ResponseEntity.ok().body(cargo);
    }
    
  
    @PostMapping("/cargos")
    public Cargo createCargo(@Valid @RequestBody Cargo cargo) throws ResourceNotFoundException {
    	return cargoRepository.save(cargo);          
    }

 

    @DeleteMapping("/cargos/{id}")
    public Map < String, Boolean > deleteCargo(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Cargo cargo = cargoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cargo não encontrado id :: " + id));

        cargoRepository.delete(cargo);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

package com.aplicacao.gerenciador.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.gerenciador.model.Cargo;



@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

}

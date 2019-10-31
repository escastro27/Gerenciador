package com.aplicacao.gerenciador.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.gerenciador.model.Status;



@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}

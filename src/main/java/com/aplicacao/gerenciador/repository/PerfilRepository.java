package com.aplicacao.gerenciador.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.gerenciador.model.Perfil;



@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}

package com.aplicacao.gerenciador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "perfis")
public class Perfil {

	
	@Id
    @SequenceGenerator(name="SeqPerfil", sequenceName="SEQ_PERFIL", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SeqPerfil")	
    private long id;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    public Perfil() {

    }

    public Perfil(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

   

	
	
    
}
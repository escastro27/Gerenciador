package com.aplicacao.gerenciador.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "usuarios")
public class Usuario {

	
    @Id
    @SequenceGenerator(name="SeqUsuario", sequenceName="SEQ_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SeqUsuario")	
    private long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "cpf", nullable = false)
    private String cpf;
    
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "cargo", nullable = false)
    private Long cargo;
    
    @JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="cargo", insertable=false, updatable=false)
	private Cargo cargoEnt;
    
    @Column(name = "perfil", nullable = false)
    private Long perfil;
    
    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="perfil", insertable=false, updatable=false)
	private Perfil perfilEnt;
    
    @Column(name = "status", nullable = false)
    private Long status; 
    
    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="status", insertable=false, updatable=false)
	private Status statusEnt;
    


    public Usuario() {

    }

    public Usuario(long id, String nome, String cpf, String sexo, LocalDate dataNascimento, Long cargo, Long perfil, Long status) {
        this.id = id;
    	this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
        this.perfil = perfil;
        this.status = status;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

   
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCargo() {
		return cargoEnt.getDescricao();
	}
	
	public void setCargo(Long cargo) {
		this.cargo = cargo;
	}
	
	public String getPerfil() {
		return perfilEnt.getDescricao();
	}

	public void setPerfil(Long perfil) {
		this.perfil = perfil;
	}

	
	public String getStatus() {
		return statusEnt.getDescricao();
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Cargo getCargoEnt() {
		return cargoEnt;
	}

	public void setCargoEnt(Cargo cargoEnt) {
		this.cargoEnt = cargoEnt;
	}

	public Perfil getPerfilEnt() {
		return perfilEnt;
	}

	public void setPerfilEnt(Perfil perfilEnt) {
		this.perfilEnt = perfilEnt;
	}
	@JsonIgnore
	public Long getCargoInsert() {
		return cargo;
	}
	@JsonIgnore
	public Long getPerfilInsert() {
		return perfil;
	}
	@JsonIgnore
	public Long getStatusInsert() {
		return status;
	}


	
	
	
    
}
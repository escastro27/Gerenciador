package com.aplicacao.gerenciador.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.gerenciador.exception.ResourceNotFoundException;
import com.aplicacao.gerenciador.model.Usuario;
import com.aplicacao.gerenciador.repository.UsuarioRepository;
import com.aplicacao.gerenciador.util.Validadores;



@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List < Usuario > getTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity < Usuario > getUsuarioById(@PathVariable(value = "id") Long usuarioId)
    throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id :: " + usuarioId));

		return ResponseEntity.ok().body(usuario);
    }
    
    @GetMapping("/usuarios/cpf/{cpf}")
    public ResponseEntity < Usuario > getUsuarioByCpf(@PathVariable(value = "cpf") String cpf)
    throws ResourceNotFoundException {
    	if (!Validadores.valida(cpf)) {
    		throw new ResourceNotFoundException("CPF inválido :: " + cpf);
    	}
    	Usuario usuario =   jdbcTemplate.queryForObject(
                   "select * from usuarios where cpf = ?",new Object[]{cpf},
 
                   (rs, rowNum) ->
                   new Usuario(rs.getLong("id"),rs.getString("nome"),rs.getString("cpf"),
                		   rs.getString("sexo"), rs.getDate("data_nascimento").toLocalDate(), Long.valueOf(rs.getString("cargo")),
                                   Long.valueOf(rs.getString("perfil")),Long.valueOf(rs.getString("status"))));
    	if (usuario == null) {
    		throw new ResourceNotFoundException("Usuário não encontrado para o cpf :: " + cpf);

    	}
    	
    	Optional<Usuario> usu = usuarioRepository.findById(usuario.getId());
		return ResponseEntity.ok().body(usu.get());
    }
    
    @GetMapping("/usuarios/cargo/{cargo}")
    public List < Usuario > getUsuarioByCargo(@PathVariable(value = "cargo") String cargo)
    throws ResourceNotFoundException {
    
    	List<Usuario> usuarios = jdbcTemplate.query(
    			"select * from usuarios where cargo = ?",
    		    new Object[] {cargo},
    		    new RowMapper<Usuario>() {
    		        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
    		        	Usuario u = new Usuario();
    		            u.setId(rs.getLong("id"));
    		            u.setNome(rs.getString("nome"));
    		            u.setCpf(rs.getString("cpf"));
    		            u.setSexo(rs.getString("sexo"));
    		            u.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
    		            u.setCargo(Long.valueOf(rs.getString("cargo")));
    		            u.setPerfil(Long.valueOf(rs.getString("perfil")));
    		            u.setStatus(Long.valueOf(rs.getString("status")));
    		            Optional<Usuario> usu = usuarioRepository.findById(u.getId());
    		            
    		            return usu.get();
    		        }
    		    });
 
                 
    	if (usuarios.isEmpty()) {
    		throw new ResourceNotFoundException("Usuário não encontrado para o cargo :: " + cargo);
    	}
		
		return usuarios;
    }
    
    @GetMapping("/usuarios/perfil/{perfil}")
    public List < Usuario > getUsuarioByPerfil(@PathVariable(value = "perfil") String perfil)
    throws ResourceNotFoundException {
    
    	List<Usuario> usuarios = jdbcTemplate.query(
    			"select * from usuarios where perfil = ?",
    		    new Object[] {perfil},
    		    new RowMapper<Usuario>() {
    		        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
    		        	Usuario u = new Usuario();
    		            u.setId(rs.getLong("id"));
    		            u.setNome(rs.getString("nome"));
    		            u.setCpf(rs.getString("cpf"));
    		            u.setSexo(rs.getString("sexo"));
    		            u.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
    		            u.setCargo(Long.valueOf(rs.getString("cargo")));
    		            u.setPerfil(Long.valueOf(rs.getString("perfil")));
    		            u.setStatus(Long.valueOf(rs.getString("status")));
    		            Optional<Usuario> usu = usuarioRepository.findById(u.getId());
    		            
    		            return usu.get();
    		        }
    		    });
 
                 
    	if (usuarios.isEmpty()) {
    		throw new ResourceNotFoundException("Usuário não encontrado para o cargo :: " + perfil);
    	}
		
		return usuarios;
    }
    
    @GetMapping("/usuarios/status/{status}")
    public List < Usuario > getUsuarioByStatus(@PathVariable(value = "status") String status)
    throws ResourceNotFoundException {
    
    	List<Usuario> usuarios = jdbcTemplate.query(
    			"select * from usuarios where status = ?",
    		    new Object[] {status},
    		    new RowMapper<Usuario>() {
    		        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
    		        	Usuario u = new Usuario();
    		            u.setId(rs.getLong("id"));
    		            u.setNome(rs.getString("nome"));
    		            u.setCpf(rs.getString("cpf"));
    		            u.setSexo(rs.getString("sexo"));
    		            u.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
    		            u.setCargo(Long.valueOf(rs.getString("cargo")));
    		            u.setPerfil(Long.valueOf(rs.getString("perfil")));
    		            u.setStatus(Long.valueOf(rs.getString("status")));
    		            Optional<Usuario> usu = usuarioRepository.findById(u.getId());
    		            
    		            return usu.get();
    		        }
    		    });
                 
    	if (usuarios.isEmpty()) {
    		throw new ResourceNotFoundException("Usuário não encontrado para o status :: " + status);
    	}
		
		return usuarios;
    }
    
    @GetMapping("/usuarios/busca1")
    public List < Usuario > getUsuarioByCPF0()
    throws ResourceNotFoundException {
    
    	List<Usuario> usuarios = jdbcTemplate.query(
    			"select * "
    			+ "from usuarios u where u.cpf like '0%'",
    		    
    		    new RowMapper<Usuario>() {
    		        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
    		        	Usuario u = new Usuario();
    		            u.setId(rs.getLong("id"));
    		            u.setNome(rs.getString("nome"));
    		            u.setCpf(rs.getString("cpf"));
    		            u.setSexo(rs.getString("sexo"));
    		            u.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
    		            u.setCargo(Long.valueOf(rs.getString("cargo")));
    		            u.setPerfil(Long.valueOf(rs.getString("perfil")));
    		            u.setStatus(Long.valueOf(rs.getString("status")));
    		            Optional<Usuario> usu = usuarioRepository.findById(u.getId());
    		            
    		            return usu.get();
    		        }
    		    });
 
    	if (usuarios.isEmpty()) {
    		throw new ResourceNotFoundException("Usuário não encontrado com cpf iniciado por zero.");
    	}
		
		return usuarios;
    }
    
    @GetMapping("/usuarios/busca2")
    public List < Usuario > getUsuarioFeminino()
    throws ResourceNotFoundException {
    
    	List<Usuario> usuarios = jdbcTemplate.query(
    			"select * from (select id, nome, cpf,sexo,data_nascimento,cargo,perfil,status,"
    			+ "TIMESTAMPDIFF(YEAR,data_nascimento,curdate()) AS idade "
    			+ "from usuarios u where u.sexo = 'F') where idade >= 18",
    		    
    		    new RowMapper<Usuario>() {
    		        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
    		        	Usuario u = new Usuario();
    		            u.setId(rs.getLong("id"));
    		            u.setNome(rs.getString("nome"));
    		            u.setCpf(rs.getString("cpf"));
    		            u.setSexo(rs.getString("sexo"));
    		            u.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
    		            u.setCargo(Long.valueOf(rs.getString("cargo")));
    		            u.setPerfil(Long.valueOf(rs.getString("perfil")));
    		            u.setStatus(Long.valueOf(rs.getString("status")));
    		            Optional<Usuario> usu = usuarioRepository.findById(u.getId());
    		            
    		            return usu.get();
    		        }
    		    });
                 
    	if (usuarios.isEmpty()) {
    		throw new ResourceNotFoundException("Usuário não encontrado com cpf iniciado por zero.");
    	}
		
		return usuarios;
    }
    
    public Integer getIdByCpfNome(String cpf, String nome)
    throws ResourceNotFoundException {
    	Integer id = 0;
    	id = jdbcTemplate.queryForObject(
                   "select count(*) from usuarios where cpf = ? and nome = ?",new Object[]{cpf,nome},
                   Integer.class);
		return id;
    }

    @PostMapping("/usuarios")
    public ResponseEntity < Usuario > createUsuario(@Valid @RequestBody Usuario usuario) throws ResourceNotFoundException {
    	Usuario usuarioRetorno = null;
    	if (!Validadores.validaUsuario(usuario)) {
    		throw new ResourceNotFoundException("Preencha todos os campos.");
    	}
    	if (!Validadores.valida(usuario.getCpf())) {
    		throw new ResourceNotFoundException("CPF inválido :: " + usuario.getCpf());
    	}
    	
    	long id = 0;
    	Integer verificacao = getIdByCpfNome(usuario.getCpf(), usuario.getNome());
    	if (verificacao == 0) {
    		
			id = jdbcTemplate.queryForObject(
							    "select SEQ_USUARIO.nextval from dual", Integer.class);
								 jdbcTemplate.update(
							      "INSERT INTO usuarios (id, nome, cpf, sexo, data_nascimento, cargo, perfil, status) VALUES (?,?, ?, ?, ?,?,?,?)", id, usuario.getNome(), usuario.getCpf(), usuario.getSexo(), 
							      usuario.getDataNascimento(),usuario.getCargoInsert(),usuario.getPerfilInsert(), usuario.getStatusInsert());
    	}	  
    	 usuarioRetorno = usuarioRepository.findById(id)
    	            .orElseThrow(() -> new ResourceNotFoundException("Usuário já existente com o cpf:: " + usuario.getCpf() + " e nome::" + usuario.getNome()));
    	 return ResponseEntity.ok().body(usuarioRetorno);           
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity < Usuario > updateUsuario(@PathVariable(value = "id") Long usuarioId,
        @Valid @RequestBody Usuario detalheUsuario) throws ResourceNotFoundException {
    	Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id :: " + usuarioId));

        usuario.setNome(detalheUsuario.getNome());
        usuario.setCpf(detalheUsuario.getCpf());
        usuario.setCargo(Long.valueOf(detalheUsuario.getCargo()));
        usuario.setDataNascimento(detalheUsuario.getDataNascimento());
        usuario.setSexo(detalheUsuario.getSexo());
        usuario.setPerfil(Long.valueOf(detalheUsuario.getPerfil()));
        usuario.setStatus(Long.valueOf(detalheUsuario.getStatus()));
        final Usuario usuarioUpdt = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioUpdt);
    }
    
    @PutMapping("/usuarios/inativar/{id}")
    public ResponseEntity < Usuario > inativarUsuario(@PathVariable(value = "id") Long usuarioId) throws ResourceNotFoundException {
    	Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id :: " + usuarioId));

       if (usuario.getStatusInsert().equals(1L)) {
    	   usuario.setStatus(2L);
    	   usuarioRepository.save(usuario);
    	   throw new ResourceNotFoundException("O usuário foi inativado com sucesso.");
       } else {
    	   throw new ResourceNotFoundException("Usuário já se encontra inativo :: " + usuario.getId());
       }
    }

    @DeleteMapping("/usuarios/{id}")
    public Map < String, Boolean > deleteUsuario(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id :: " + id));

        usuarioRepository.delete(usuario);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

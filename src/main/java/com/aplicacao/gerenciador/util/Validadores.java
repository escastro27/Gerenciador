package com.aplicacao.gerenciador.util;

import com.aplicacao.gerenciador.model.Usuario;

import br.com.caelum.stella.validation.CPFValidator;

public class Validadores {

	
	public static boolean valida(String cpf) { 
	    CPFValidator cpfValidator = new CPFValidator(); 
	    try{ cpfValidator.assertValid(cpf); 
	    return true; 
	    }catch(Exception e){ 
	        return false; 
	        } 
	    }
	
	public static boolean validaUsuario(Usuario usuario) {
		if (usuario.getCargoInsert() == null || usuario.getCpf() == null || usuario.getDataNascimento() == null
				|| usuario.getNome() == null || usuario.getPerfilInsert() == null || usuario.getSexo() == null
				|| usuario.getStatusInsert() == null) {
			return false;
		}
		return true;
	}
	
}

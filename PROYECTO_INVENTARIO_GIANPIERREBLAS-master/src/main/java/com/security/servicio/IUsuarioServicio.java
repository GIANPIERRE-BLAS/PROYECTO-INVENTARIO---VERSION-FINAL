package com.security.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.security.controlador.dto.UsuarioRegistroDTO;
import com.security.modelo.Usuario;


public interface IUsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);	
	public List<Usuario> listarUsuarios();
}

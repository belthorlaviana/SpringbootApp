package com.example.SpringbootApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringbootApp.modelo.UsuarioVO;
import com.example.SpringbootApp.servicio.UsuarioService;



@RestController
@RequestMapping("/UsuarioController")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	@GetMapping("${endpoints.usuarioController.insertUsuario}")
	public ResponseEntity<Optional<UsuarioVO>> insertUsuario(@PathVariable final String nif) {
		
		 Optional<UsuarioVO>usuario=usuarioService.findUsuarioByNif(nif);
		
		if(usuario.isPresent()) {
			return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.OK);
		}else {
			return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	@GetMapping("${endpoints.usuarioController.getUsuarioByNif}/{nif}")
	public ResponseEntity<Optional<UsuarioVO>> getUsuarioByNif(@PathVariable final String nif) {
		
		 Optional<UsuarioVO>usuario=usuarioService.findUsuarioByNif(nif);
		
		if(usuario.isPresent()) {
			return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.OK);
		}else {
			return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.NOT_FOUND);
		}
	}

}

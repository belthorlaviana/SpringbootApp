package com.example.SpringbootApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringbootApp.modelo.UsuarioVO;
import com.example.SpringbootApp.servicio.UsuarioService;



@RestController
@RequestMapping("/UsuarioController")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;


  // INSERT
  @GetMapping("${endpoints.usuarioController.insertUsuario}")
  public ResponseEntity<Optional<UsuarioVO>> insertUsuario(@PathVariable final String nif) {

    Optional<UsuarioVO> usuario = usuarioService.findUsuarioByNif(nif);

    if (usuario.isPresent()) {
      return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.OK);
    } else {
      return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.NOT_FOUND);
    }
  }

  // GET CON PATH PARAM
  @GetMapping("${endpoints.usuarioController.getUsuarioByNif}/{nif}")
  public ResponseEntity<Optional<UsuarioVO>> getUsuarioByNif(@PathVariable final String nif) {

    Optional<UsuarioVO> usuario = usuarioService.findUsuarioByNif(nif);

    if (usuario.isPresent()) {
      return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.OK);
    } else {
      return new ResponseEntity<Optional<UsuarioVO>>(usuario, HttpStatus.NOT_FOUND);
    }
  }

  // GET CON REQUEST PARAM
  @GetMapping("${endpoints.usuarioController.getUsuariosByNameAndLastName}")
  @ResponseBody
  public ResponseEntity<Optional<List<UsuarioVO>>> getUsuariosByNameAndLastName(
      @RequestParam(name = "name") final String name,
      @RequestParam(name = "lastName") final String lastName) {

    Optional<List<UsuarioVO>> listaUsuarios =
        usuarioService.findUsuariosByNameAndLastName(name, lastName);

    if (listaUsuarios.isPresent()) {
      return new ResponseEntity<Optional<List<UsuarioVO>>>(listaUsuarios, HttpStatus.OK);
    } else {
      return new ResponseEntity<Optional<List<UsuarioVO>>>(listaUsuarios, HttpStatus.NOT_FOUND);
    }

  }


}

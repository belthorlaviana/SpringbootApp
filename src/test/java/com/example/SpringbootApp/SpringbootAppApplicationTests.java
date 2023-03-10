package com.example.SpringbootApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.example.SpringbootApp.modelo.RolUsuarioVO;
import com.example.SpringbootApp.modelo.RolVO;
import com.example.SpringbootApp.modelo.UsuarioVO;
import com.example.SpringbootApp.servicio.RolService;
import com.example.SpringbootApp.servicio.RolUsuarioService;
import com.example.SpringbootApp.servicio.UsuarioService;

@SpringBootTest
class SpringbootAppApplicationTests {


  @Autowired
  RolService rolService;

  @Autowired
  UsuarioService usuarioService;

  @Autowired
  RolUsuarioService rolUsuarioService;

  @Test
  void Testcase_1() {


  }

  // 3-Inserta registros en la tabla usuarios
  @Test
  void Testcase_2() {
    UsuarioVO usuario = new UsuarioVO("00000000-f", "Beltran", "Otero", LocalDate.of(1990, 9, 5),
        new ArrayList<RolUsuarioVO>());

    UsuarioVO usuario2 =
        new UsuarioVO("11111111-f", "Vicente", "Mediavilla", LocalDate.of(1992, 10, 3),
            new ArrayList<RolUsuarioVO>());

    UsuarioVO usuario3 = new UsuarioVO("22222222-f", "Maria", "Fernandez", LocalDate.of(1996, 6, 5),
        new ArrayList<RolUsuarioVO>());

    UsuarioVO usuario4 =
        new UsuarioVO("33333333-f", "Elena", "Martinez", LocalDate.of(1999, 10, 11),
            new ArrayList<RolUsuarioVO>());

    UsuarioVO usuario5 = new UsuarioVO("44444444-f", "Cristina", "Otero", LocalDate.of(2000, 11, 5),
        new ArrayList<RolUsuarioVO>());

    UsuarioVO usuario6 = new UsuarioVO("55555555-f", "Alberto", "Romero", LocalDate.of(1991, 4, 1),
        new ArrayList<RolUsuarioVO>());

    UsuarioVO usuarioRepetido =
        new UsuarioVO("12345671-f", "Beltran", "Otero", LocalDate.of(1990, 9, 5),
            new ArrayList<RolUsuarioVO>());

    assertNotNull(usuarioService.save(usuario));
    assertNotNull(usuarioService.save(usuario2));
    assertNotNull(usuarioService.save(usuario3));
    assertNotNull(usuarioService.save(usuario4));
    assertNotNull(usuarioService.save(usuario5));
    assertNotNull(usuarioService.save(usuario6));
    assertNotNull(usuarioService.save(usuarioRepetido));
  }

  // 4-Asigna varios roles a un usuario que ya existe en la tabla
  @Test
  void Testcase_3() {
    // busco usuario en la database
    UsuarioVO usuario = usuarioService.findUsuarioByNif("34567867-f").get();
    UsuarioVO usuario2 = usuarioService.findUsuarioByNif("99999999-f").get();
    // busco roles en la database
    RolVO rol1 = rolService.findRolesByDenominacion("administrador").get();
    RolVO rol2 = rolService.findRolesByDenominacion("usuario").get();

    // grabo en la base de datos
    assertNotNull(rolUsuarioService.save(new RolUsuarioVO(usuario, rol1)));
    assertNotNull(rolUsuarioService.save(new RolUsuarioVO(usuario, rol2)));
    assertNotNull(rolUsuarioService.save(new RolUsuarioVO(usuario2, rol1)));
    // UsuarioVO usuario3 = usuarioService.findByNif2("34567867-f").get();
    // UsuarioVO usuario4 = usuarioService.findByNif2("34567867-f").get();
  }

  // 5-Asigna un rol a un usuario que ya lo tenía, controla el error y muestra el
  // mensaje correspondiente
  @Test
  void Testcase_4() {
    String mensajeError = null;
    // busco usuario en la database
    UsuarioVO usuario = usuarioService.findUsuarioByNif("34567867-f").get();
    // busco roles en la database
    RolVO rol1 = rolService.findRolesByDenominacion("administrador").get();

    try {
      // al usuario ya se le asignó el rol "administrador" en el case anterior,ahora
      // tratamos de volver a darle el mismo rol.
      rolUsuarioService.save(new RolUsuarioVO(usuario, rol1));
    } catch (DataIntegrityViolationException e) {
      mensajeError = e.getCause().getCause().toString();
    }

    assertTrue(mensajeError.contains("Duplicate entry '1-1' for key 'roles_usuarios"));

  }

  // 6-Intenta buscar un usuario que no existe en la base de datos y controla el
  // error mostrando el mensaje correspondiente.
  @Test
  void Testcase_5() {
    UsuarioVO usuario = null;
    String mensajeError = null;

    try {
      usuario = usuarioService.findUsuarioByNif("34567844467-f").get();
    } catch (NoSuchElementException e) {
      mensajeError = e.getMessage();
    }
    assertEquals("No value present", mensajeError);
  }

  // 7- Utiliza el motor de búsquedas de Spring para mostrar todos los roles de un
  // usuario concreto
  @Test
  void Testcase_6() {
    // busco usuario por id
    Optional<UsuarioVO> usuario = usuarioService.findUsuarioById(1);
    // forma 1:muestro roles
    System.out
        .println("-----------------ROLES DEL USUARIO CON ID=1 34567867-f -----------------------");
    if (usuario.isPresent()) {
      usuario.get().getRegistros().forEach((registro) -> {
        System.out.println(registro.getRol().getDenominacion());
      });
    }
    System.out
        .println("------------------------------------------------------------------------------");
    assertTrue(usuario.get().getRegistros().size() == 2);
  }

  // 8- Utiliza el motor de búsquedas de Spring para mostrar todos los usuarios
  // con un rol en concreto
  @Test
  void Testcase_7() {
    // busco el rol por id=1 = administrador
    Optional<RolVO> rol = rolService.findRolById(1);
    // forma 1:muestro usuarios con ese rol
    System.out
        .println("-----------------USUARIOS CON ROL ADMINISTRADOR-------------------------------");
    if (rol.isPresent()) {
      rol.get().getRegistros().forEach((registro) -> {
        System.out.println(registro.getUsuario().getNif());
      });
    }
    System.out
        .println("------------------------------------------------------------------------------");
    assertEquals(2, rol.get().getRegistros().size());

  }

  // 9-Utiliza un @Query para consultar el nombre de todos los usuarios con un rol
  // en concreto.
  @Test
  void Testcase_8() {
    // muestro una lista de nombres con todos los usuarios con rol administrador
    Optional<List<String>> lista = usuarioService.findNamesWithRol("administrador");
    System.out
        .println("------LISTA DE NOMBRE DE USUARIOS CON ROL EN CONCRETO= ADMINISTRADOR----------");
    if (lista.isPresent()) {
      lista.get().forEach((nif) -> {
        System.out.println(nif);
      });
    }
    System.out
        .println("------------------------------------------------------------------------------");

  }

}

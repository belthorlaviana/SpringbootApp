package com.example.SpringbootApp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringbootApp.modelo.UsuarioVO;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioVO, Integer> {

  public Optional<UsuarioVO> findByNif(String nif);


  @Query(value = "SELECT e FROM UsuarioVO e JOIN FETCH e.registros t where e.nif=?1")
  public Optional<UsuarioVO> findByNif2(String nif);


  @Query(value = "SELECT  usu.nif\r\n" + "FROM tarea1.usuarios usu\r\n"
      + "INNER JOIN tarea1.roles_usuarios rol_usu\r\n" + "ON usu.idusuario = rol_usu.idusuario\r\n"
      + "INNER JOIN tarea1.roles rol\r\n" + "On rol_usu.idrol=rol.idrol\r\n"
      + "WHERE rol.denominacion=?1", nativeQuery = true)
  public Optional<List<String>> findNamesWithRol(String rol);


  @Query(
      value = "SELECT e FROM UsuarioVO e where e.name=?1 and e.lastName=?2")
  public Optional<List<UsuarioVO>> findUsuariosByNameAndLastName(String name, String lastName);



}

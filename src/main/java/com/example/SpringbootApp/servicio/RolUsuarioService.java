package com.example.SpringbootApp.servicio;

import java.util.List;
import java.util.Optional;

import com.example.SpringbootApp.modelo.RolUsuarioVO;
import com.example.SpringbootApp.modelo.UsuarioVO;



public interface RolUsuarioService {

  public <S extends RolUsuarioVO> S save(S RolUsuario);

  public Iterable<RolUsuarioVO> findAll();

  public Optional<List<RolUsuarioVO>> findRolUsuarioVObyUsuario(UsuarioVO usuario);

}

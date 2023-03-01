package com.example.SpringbootApp.servicio;

import java.util.List;
import java.util.Optional;

import com.example.SpringbootApp.modelo.UsuarioVO;



public interface UsuarioService {

  public <S extends UsuarioVO> S save(S usuario);

  public Optional<UsuarioVO> findUsuarioByNif(String nif);

  public Optional<UsuarioVO> findUsuarioById(int id);

  public Optional<List<String>> findNamesWithRol(String rol);

  public Optional<UsuarioVO> findByNif2(String nif);
}

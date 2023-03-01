package com.example.SpringbootApp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringbootApp.modelo.RolUsuarioVO;
import com.example.SpringbootApp.modelo.UsuarioVO;

@Repository
public interface RolUsuarioRepository extends CrudRepository<RolUsuarioVO, Integer> {

  public Optional<List<RolUsuarioVO>> findByUsuario(UsuarioVO usuario);
}

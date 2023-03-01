package com.example.SpringbootApp.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringbootApp.modelo.UsuarioVO;
import com.example.SpringbootApp.repository.UsuarioRepository;
import com.example.SpringbootApp.servicio.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  UsuarioRepository usuarioRepo;

  @Override
  public <S extends UsuarioVO> S save(S usuario) {

    return usuarioRepo.save(usuario);
  }

  @Override
  public Optional<UsuarioVO> findUsuarioByNif(String nif) {

    return usuarioRepo.findByNif(nif);
  }

  @Override
  public Optional<UsuarioVO> findUsuarioById(int id) {

    return usuarioRepo.findById(id);

  }

  public Optional<List<String>> findNamesWithRol(String rol) {
    return usuarioRepo.findNamesWithRol(rol);
  }

  @Override
  public Optional<UsuarioVO> findByNif2(String nif) {
    // TODO Auto-generated method stub
    return usuarioRepo.findByNif2(nif);
  }

}

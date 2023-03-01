package com.example.SpringbootApp.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringbootApp.modelo.RolUsuarioVO;
import com.example.SpringbootApp.modelo.UsuarioVO;
import com.example.SpringbootApp.repository.RolUsuarioRepository;
import com.example.SpringbootApp.servicio.RolUsuarioService;

@Service
public class RolUsuarioServiceImpl implements RolUsuarioService {

  @Autowired
  private RolUsuarioRepository rolUsuarioRepo;

  @Override
  public <S extends RolUsuarioVO> S save(S RolUsuario) {

    return rolUsuarioRepo.save(RolUsuario);
  }

  @Override
  public Iterable<RolUsuarioVO> findAll() {
    // TODO Auto-generated method stub
    return rolUsuarioRepo.findAll();
  }

  @Override
  public Optional<List<RolUsuarioVO>> findRolUsuarioVObyUsuario(UsuarioVO usuario) {
    // TODO Auto-generated method stub
    return rolUsuarioRepo.findByUsuario(usuario);
  }

}

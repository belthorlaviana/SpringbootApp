package com.example.SpringbootApp.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles_usuarios",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"idusuario", "idrol"})})
public class RolUsuarioVO {
  // ATRIBUTOS
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int RolUsuario;

  @ManyToOne
  @JoinColumn(name = "idusuario")
  private UsuarioVO usuario;

  @ManyToOne
  @JoinColumn(name = "idrol")
  private RolVO rol;

  // CONSTRUCTOR
  public RolUsuarioVO(UsuarioVO usuario, RolVO rol) {
    super();
    this.usuario = usuario;
    this.rol = rol;
  }

}

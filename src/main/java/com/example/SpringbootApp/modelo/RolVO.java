package com.example.SpringbootApp.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles", uniqueConstraints = @UniqueConstraint(columnNames = "denominacion"))
public class RolVO {
  // ATRIBUTOS
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idrol;

  private String denominacion;

  @OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
  private List<RolUsuarioVO> registros;

  // CONSTRUCTOR
  public RolVO(String denominacion, List<RolUsuarioVO> usuarios) {
    super();
    this.denominacion = denominacion;
    this.registros = usuarios;
  }
}

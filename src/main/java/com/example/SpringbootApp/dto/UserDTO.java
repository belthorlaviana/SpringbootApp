package com.example.SpringbootApp.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	  private String nif;

	  private String name;

	  private String lastName;

	  private LocalDate dateBirth;
}

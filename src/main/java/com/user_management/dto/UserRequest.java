package com.user_management.dto;

import com.user_management.model.RoleEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

  @Email(message = "El email debe ser válido")
  @NotBlank(message = "El email no puede estar vacío")
  private String email;

  @NotBlank(message = "La contraseña no puede estar vacía")
  @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
  private String password;

  private RoleEnum role;
}

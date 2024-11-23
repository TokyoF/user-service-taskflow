
package com.user_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder

public class RoleRequest {

  @NotBlank(message = "El nombre del rol no puede estar vacío")
  private String roleName;
}

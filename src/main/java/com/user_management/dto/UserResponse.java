
package com.user_management.dto;

import com.user_management.model.RoleEnum;
import lombok.*;

@Getter
@Setter
@Builder
public class UserResponse {

  private Long id;
  private String email;
  private RoleEnum role;
}

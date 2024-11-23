
package com.user_management.dto;

import com.user_management.model.RoleEnum;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {

  private Long id;
  private RoleEnum name;
}

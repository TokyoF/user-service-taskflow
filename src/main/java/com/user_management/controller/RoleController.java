package com.user_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import com.user_management.dto.RoleResponse;
import com.user_management.service.RoleService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

  private final RoleService roleService;

  /**
   * Obtiene todos los roles disponibles.
   */
  @GetMapping
  public ResponseEntity<List<RoleResponse>> getAllRoles() {
    List<RoleResponse> roles = roleService.getAllRoles().stream()
        .map(role -> new RoleResponse(role.getId(), role.getName()))
        .collect(Collectors.toList());
    return ResponseEntity.ok(roles);
  }
}

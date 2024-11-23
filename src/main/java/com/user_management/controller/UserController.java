
package com.user_management.controller;

import com.user_management.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.user_management.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import com.user_management.dto.*;
import com.user_management.model.UserEntity;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

  private final UserService userService;

  /**
   * Obtiene todos los usuarios registrados.
   */
  @GetMapping
  public ResponseEntity<List<UserResponse>> getAllUsers() {
    List<UserResponse> users = userService.getAllUsers().stream()
        .map(this::convertToResponse)
        .collect(Collectors.toList());
    return ResponseEntity.ok(users);
  }

  /**
   * Obtiene un usuario por su ID.
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
    UserEntity user = userService.findById(id);
    return ResponseEntity.ok(convertToResponse(user));
  }

  /**
   * Crea un nuevo usuario.
   */
  @PostMapping
  public ResponseEntity<UserResponse> createUser(@RequestBody @Validated UserRequest request) {
    UserEntity user = userService.createUser(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(convertToResponse(user));
  }

  /**
   * Elimina un usuario por su ID.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

  /**
   * Convierte una entidad de usuario a un DTO de respuesta.
   */
  private UserResponse convertToResponse(UserEntity user) {
    return UserResponse.builder()
        .id(user.getId())
        .email(user.getEmail())
        .role(user.getRole().getName())
        .build();
  }
}

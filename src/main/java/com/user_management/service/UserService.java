package com.user_management.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.user_management.dto.UserRequest;
import com.user_management.exception.UserNotFoundException;
import com.user_management.exception.RoleNotFoundException;
import com.user_management.model.RoleEntity;
import com.user_management.model.UserEntity;
import com.user_management.repository.RoleRepository;
import com.user_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  /**
   * Crea un nuevo usuario con un rol asignado.
   * 
   * @param request Datos del usuario.
   * @return Usuario creado.
   */
  public UserEntity createUser(UserRequest request) {
    RoleEntity role = roleRepository.findByName(request.getRole())
        .orElseThrow(() -> new RoleNotFoundException("Rol no encontrado: " + request.getRole()));

    UserEntity user = UserEntity.builder()
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(role)
        .build();

    return userRepository.save(user);
  }

  /**
   * Obtiene todos los usuarios registrados.
   */
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  /**
   * Busca un usuario por su ID.
   * 
   * @param id ID del usuario.
   * @return Entidad del usuario.
   * @throws UserNotFoundException Si el usuario no existe.
   */
  public UserEntity findById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + id));
  }

  /**
   * Elimina un usuario por su ID.
   * 
   * @param id ID del usuario.
   */
  public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      throw new UserNotFoundException("Usuario no encontrado con ID: " + id);
    }
    userRepository.deleteById(id);
  }
}

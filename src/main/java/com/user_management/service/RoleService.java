package com.user_management.service;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.stereotype.Service;

import com.user_management.model.RoleEntity;
import com.user_management.model.RoleEnum;
import com.user_management.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class RoleService {

  private final RoleRepository roleRepository;

  /**
   * Obtiene todos los roles disponibles.
   */
  public List<RoleEntity> getAllRoles() {
    return roleRepository.findAll();
  }

  /**
   * Busca un rol por su nombre.
   * 
   * @param name Nombre del rol.
   * @return Entidad del rol.
   * @throws RoleNotFoundException Si el rol no existe.
   */
  public RoleEntity findByName(RoleEnum name) throws RoleNotFoundException {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new RoleNotFoundException("Rol no encontrado: " + name));
  }
}

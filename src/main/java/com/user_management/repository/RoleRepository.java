
package com.user_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user_management.model.RoleEntity;
import com.user_management.model.RoleEnum;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
  Optional<RoleEntity> findByName(RoleEnum name);
}

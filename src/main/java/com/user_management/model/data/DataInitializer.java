package com.user_management.model.data;

import com.user_management.model.RoleEntity;
import com.user_management.model.RoleEnum;
import com.user_management.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

  private final RoleRepository roleRepository;

  @Bean
  public ApplicationRunner initRoles() {
    return args -> {
      for (RoleEnum role : RoleEnum.values()) {
        if (roleRepository.findByName(role).isEmpty()) {
          RoleEntity roleEntity = RoleEntity.builder()
              .name(role)
              .build();
          roleRepository.save(roleEntity);
        }
      }
    };
  }
}

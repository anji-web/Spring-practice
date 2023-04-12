package com.marketplace.practice.marketplacepractice.repo;

import com.marketplace.practice.marketplacepractice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByRoleName(String roleName);
}

package com.marketplace.practice.marketplacepractice.repo;

import com.marketplace.practice.marketplacepractice.model.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
  Optional<Users> findByUserName(String userName);
  Boolean existsByUserName(String userName);
  Boolean existsByEmail(String email);
}

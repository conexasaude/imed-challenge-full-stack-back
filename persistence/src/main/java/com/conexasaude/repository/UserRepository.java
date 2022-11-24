package com.conexasaude.repository;

import com.conexasaude.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  String findByUsername =
      "select hp.roles from health_professional hp where hp.username = :username "
          + "union select pa.roles from patient pa where pa.username = :username";

  @Query(value = findByUsername, nativeQuery = true)
  String findByUsername(String username);
}

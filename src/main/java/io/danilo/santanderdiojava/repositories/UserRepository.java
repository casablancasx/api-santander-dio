package io.danilo.santanderdiojava.repositories;

import io.danilo.santanderdiojava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

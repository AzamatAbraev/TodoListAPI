package org.todo.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todo.todolistapi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

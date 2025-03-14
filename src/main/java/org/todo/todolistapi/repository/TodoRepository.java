package org.todo.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.todo.todolistapi.model.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}

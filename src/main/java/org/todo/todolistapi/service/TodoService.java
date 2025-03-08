package org.todo.todolistapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.todo.todolistapi.model.Todo;
import org.todo.todolistapi.repository.TodoRepository;


@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Page<Todo> getTodos(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);

        if (existingTodo == null) {
            return null;
        }

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());

        return todoRepository.save(existingTodo);
    }

    public boolean deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            return false;
        }

        todoRepository.deleteById(id);
        return true;
    }
}

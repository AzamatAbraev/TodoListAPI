package org.todo.todolistapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.todolistapi.model.Todo;
import org.todo.todolistapi.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<Page<Todo>> getTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Todo> todos = todoService.getTodos(pageable);

        if (todos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(todos.getTotalElements()))
                .body(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);

        if (todo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);

        if (updatedTodo == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        boolean isDeleted = todoService.deleteTodo(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}

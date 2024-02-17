package com.todo.model.todo.service;

import com.todo.model.todo.entity.Todo;

import java.util.List;

public interface TodoJpaService {
    List<Todo> getAllTodos();

    Todo createTodo(Todo todo);

    Todo getTodoById(Long id);

    Todo updateTodo(Long id, Todo updatedTodo);

    void deleteTodo(Long id);
}

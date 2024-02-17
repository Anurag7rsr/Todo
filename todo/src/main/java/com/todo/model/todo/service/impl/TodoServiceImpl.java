package com.todo.model.todo.service.impl;

import com.todo.model.todo.entity.Todo;
import com.todo.model.todo.exception.TodoNotFoundException;
import com.todo.model.todo.repository.TodoRepository;
import com.todo.model.todo.service.TodoJpaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoJpaService {

    private TodoRepository todoRepository;

    public TodoServiceImpl( TodoRepository todoRepository){
        this.todoRepository=todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Override
    public Todo updateTodo(Long id, Todo updatedTodo) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        updatedTodo.setId(id);
        return todoRepository.save(updatedTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
    }
}

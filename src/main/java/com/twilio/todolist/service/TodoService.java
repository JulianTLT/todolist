package com.twilio.todolist.service;

import com.twilio.todolist.entity.Todo;
import com.twilio.todolist.entity.TodoState;
import com.twilio.todolist.repository.TodoDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public Todo createTodo(String name, String description, TodoState state) {
        Todo todo = new Todo()
                .setName(name)
                .setDescription(description)
                .setState(state);

        todoDao.save(todo);
        return todo;
    }

    public List<Todo> getAllTodos(){
        List<Todo> todos = new ArrayList<>();
        todoDao.findAll().forEach(todos::add);
        return todos;
    }

    public Todo deleteTodo(int id){
        Optional<Todo> todo = todoDao.findById(id);
        todoDao.deleteById(id);
        return todo.orElseThrow();
    }

    public Todo getTodo(int id){
        return todoDao.findById(id).orElseThrow();
    }



}

package com.twilio.todolist.service;

import com.twilio.todolist.entity.Todo;
import com.twilio.todolist.entity.TodoState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>();
    private int sequence = 1;

    public Todo createTodo(String name, String description, TodoState state) {
        Todo todo = new Todo()
                .setId(sequence++)
                .setName(name)
                .setDescription(description)
                .setState(state);

        todos.add(todo);
        return todo;
    }

    public List<Todo> getAllTodos(){
        return todos;
    }

    public Todo deleteTodo(int id){

        Optional<Todo> todo = todos.stream().filter(t -> t.getId() == id).findFirst();
        todo.ifPresent(value -> todos.remove(value));
        return todo.orElseThrow();
    }

    public Todo getTodo(int id){
        return todos.stream().filter(t -> t.getId() == id).findFirst().orElseThrow();
    }



}

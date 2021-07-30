package com.twilio.todolist.controllers;


import com.twilio.todolist.entity.Todo;
import com.twilio.todolist.model.TodoRequest;
import com.twilio.todolist.model.TodoResponse;
import com.twilio.todolist.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class TodosController {

    private TodoService todoService;

    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    private void logIp() {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            log.error(e.getMessage(),e);
        }
        String ip = localHost.getHostAddress();
        log.info("Hi!! im a pod and my ip is [{}]",ip);
    }

    @GetMapping("/todos")
    public ResponseEntity<TodoResponse> getTodos(){
        logIp();
        ResponseEntity<TodoResponse> response;
        try{
            log.info("Calling GET [/todos]");
            List<Todo> allTodos = todoService.getAllTodos();

            response = new ResponseEntity<>(new TodoResponse().setTodos(allTodos),
                    HttpStatus.OK);
        }catch (Exception e) {
            response = new ResponseEntity<>(new TodoResponse().setMessage(e.getMessage()),
                    HttpStatus.BAD_REQUEST);
            log.error("There was an exception on GET [/todos] ", e);
        }
        return response;
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Integer id) {
        logIp();
        ResponseEntity<TodoResponse> response;
        try{
            log.info("Calling GET [/todos/{id}] with id [{}]", id);
            Todo todo = todoService.getTodo(id);

            response = new ResponseEntity<>(new TodoResponse().setTodos(Collections.singletonList(todo)),
                    HttpStatus.OK);
        }catch (Exception e) {
            response = new ResponseEntity<>(new TodoResponse().setMessage(e.getMessage()),
                    HttpStatus.BAD_REQUEST);
            log.error("There was an exception on GET [/todos/{id}] with id [{}]", id, e);
        }
        return response;
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest todoRequest) {
        logIp();
        ResponseEntity<TodoResponse> response;
        try{
            log.info("Calling PUT [/todos] with todoRequest [{}]", todoRequest);
            Todo todo = todoService.createTodo(todoRequest.getName(),
                    todoRequest.getDescription(),
                    todoRequest.getTodoState());

            response = new ResponseEntity<>(new TodoResponse().setTodos(Collections.singletonList(todo)),
                    HttpStatus.OK);
        }catch (Exception e) {
            response = new ResponseEntity<>(new TodoResponse().setMessage(e.getMessage()),
                    HttpStatus.BAD_REQUEST);
            log.error("There was an exception on PUT [/todos] with todoRequest [{}]", todoRequest, e);
        }
        return response;
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<TodoResponse> deleteTodo(@PathVariable Integer id) {
        logIp();
        ResponseEntity<TodoResponse> response;
        try{
            log.info("Calling Delete [/todos/{id}] with id [{}]", id);
            Todo todo = todoService.deleteTodo(id);

            response = new ResponseEntity<>(new TodoResponse().setTodos(Collections.singletonList(todo)),
                    HttpStatus.OK);
        }catch (Exception e) {
            response = new ResponseEntity<>(new TodoResponse().setMessage(e.getMessage()),
                    HttpStatus.BAD_REQUEST);
            log.error("There was an exception on Delete [/todos/{id}] with id [{}]", id, e);
        }
        return response;
    }
}

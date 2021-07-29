package com.twilio.todolist.controllers;

import com.twilio.todolist.entity.Todo;
import com.twilio.todolist.entity.TodoState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodosController {
    @GetMapping("/todos")
    public ResponseEntity<Todo> getTodos(){
        Todo todo = new Todo("new todo", "testing", TodoState.TO_DO);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

}

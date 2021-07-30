package com.twilio.todolist.model;

import com.twilio.todolist.entity.Todo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class TodoResponse {
    String message;
    List<Todo> todos;
}

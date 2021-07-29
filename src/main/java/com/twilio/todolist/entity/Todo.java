package com.twilio.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Todo {
    String name;
    String description;
    TodoState state;
}

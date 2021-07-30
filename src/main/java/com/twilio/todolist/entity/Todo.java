package com.twilio.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Todo {
    public Todo(){}
    int id;
    String name;

    String description;

    TodoState state;
}

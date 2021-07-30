package com.twilio.todolist.model;

import com.twilio.todolist.entity.TodoState;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TodoRequest {
    String name;
    String description;
    TodoState todoState;
}

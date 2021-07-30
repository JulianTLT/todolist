package com.twilio.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "todo")
public class Todo {
    public Todo(){}
    @Id
    @SequenceGenerator(name="todo_seq",
            sequenceName="todo_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="todo_seq")
    @Column(name="id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "state")
    TodoState state;
}

package com.twilio.todolist.repository;

import com.twilio.todolist.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends CrudRepository<Todo, Integer> {

}

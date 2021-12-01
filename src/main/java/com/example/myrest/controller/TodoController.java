package com.example.myrest.controller;

import com.example.myrest.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private HashMap<String, Todo> todoList = new HashMap<>();


    @PostMapping("/add")
    public String addTodo(@RequestBody Todo todo) {
        todoList.put(todo.getId(), todo);
        return "Added";
    }

    @GetMapping("/all")
    public HashMap<String, Todo> getTodoList() {
        return todoList;
    }

    @GetMapping("/{id}")
    public Todo getTodoList(@PathVariable(name = "id") String id) {
        return todoList.get(id);
    }

    @PutMapping("/{id}")
    public Todo editTodo(@PathVariable(name = "id") String id, @RequestBody Todo todo) {
        todoList.put(id, todo);
        return todo;
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable(name = "id") String id) {
        todoList.remove(id);
        return "Deleted";
    }

}



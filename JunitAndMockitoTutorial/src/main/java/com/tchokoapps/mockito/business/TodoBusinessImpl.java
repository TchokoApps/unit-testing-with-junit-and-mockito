package com.tchokoapps.mockito.business;

import com.tchokoapps.mockito.api.TodoService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> todos = todoService.retrieveTodos(user);
        return todos.stream().filter(s -> s.contains("Spring")).collect(Collectors.toList());
    }

    public List<String> deleteTodosNotRelatedToSpring(String todo) {
        return Arrays.asList("Book");
    }
}

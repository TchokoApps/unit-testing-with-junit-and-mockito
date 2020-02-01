package com.tchokoapps.mockito.business;

import com.tchokoapps.mockito.api.TodoService;
import com.tchokoapps.mockito.api.TodoServiceStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoBusinessImplTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> springTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertThat(springTodos.size()).isEqualTo(2);
        assertThat(springTodos.get(0)).contains("Spring");
        assertThat(springTodos.get(1)).contains("Spring");
    }
}
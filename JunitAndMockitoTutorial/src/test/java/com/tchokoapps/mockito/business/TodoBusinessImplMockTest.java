package com.tchokoapps.mockito.business;

import com.tchokoapps.mockito.api.TodoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest {

    @Mock
    private TodoService todoServiceMock;

    @Mock
    private List<String> booksMock;

    private TodoBusinessImpl todoBusiness;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        todoBusiness = new TodoBusinessImpl(todoServiceMock);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingAStub() {
        // Arrange
        List<String> books = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
        doReturn(books).when(todoServiceMock).retrieveTodos("dummy");

        //Act
        List<String> retrievedBooks = todoBusiness.retrieveTodosRelatedToSpring("dummy");

        // Asserts
        verify(todoServiceMock, times(1)).retrieveTodos("dummy");
        assertThat(retrievedBooks.size()).isEqualTo(2);
    }

    @Test
    public void retrieveTodosRelatedToSpring_verify() {
        doNothing().when(todoServiceMock).deleteTodo("Book");

        todoBusiness.deleteTodosNotRelatedToSpring("Book");

        verify(todoServiceMock, never()).deleteTodo("Book");
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingArgumentCapture() {
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
    }

    @Test
    public void testListMock() {
        doReturn(2).when(booksMock).size();
        assertThat(booksMock.size()).isEqualTo(2);

        doReturn("charles").when(booksMock).get(0);
        assertThat(booksMock.get(0)).isEqualTo("charles");
        assertThat(booksMock.get(1)).isEqualTo(null);

        doReturn("pat").when(booksMock).get(anyInt());
        assertThat(booksMock.get(0)).isEqualTo("pat");
    }
}
package at.nacs.todos.communication;

import at.nacs.todos.logic.ToDoManager;
import at.nacs.todos.persistence.domain.ToDo;
import at.nacs.todos.persistence.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    ToDoManager manager;

    @MockBean
    ToDoRepository repository;

    String url = "/todos";

    @BeforeEach
    void before() {
        manager.deleteAll();
        todo = ToDo.builder().title("Test").build();
    }

    @Test
    void get() {
        restTemplate.getForObject(url, ToDo[].class);
        Mockito.verify(manager).findAll();
    }

    @Test
    void getOne() {
        restTemplate.getForObject("/todos/learning mongodb",ToDo.class);
        Mockito.verify(manager).findOne();
    }

    @Test
    void post() {
    }

    @Test
    void done() {
    }

    @Test
    void delete() {
    }
}
package at.nacs.todos.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager manager;

    @MockBean



    @Test
    void findAll() {
    }

    @Test
    void findOne() {
    }

    @Test
    void save() {
    }

    @Test
    void markAsDone() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}
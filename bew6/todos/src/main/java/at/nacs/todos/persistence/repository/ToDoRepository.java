package at.nacs.todos.persistence.repository;

import at.nacs.todos.persistence.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo,String> {
}

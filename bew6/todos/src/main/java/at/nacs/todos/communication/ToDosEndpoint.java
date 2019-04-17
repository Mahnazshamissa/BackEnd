package at.nacs.todos.communication;

import at.nacs.todos.logic.ToDoManager;
import at.nacs.todos.persistence.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDosEndpoint {

    private final ToDoManager manager;

    @GetMapping
    List<ToDo> get() {
        return manager.findAll();
    }

    @GetMapping("/{id}")
    ToDo getOne(@PathVariable String id) {
        return manager.findOne(id).orElse(null);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return manager.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo done(@PathVariable String id) {
        return manager.markAsDone(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        manager.delete(id);
    }
}

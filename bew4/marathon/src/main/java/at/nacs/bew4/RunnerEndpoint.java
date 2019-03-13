package at.nacs.bew4;

import at.nacs.bew4.domain.Runner;
import at.nacs.bew4.domain.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runners")
@RequiredArgsConstructor
public class RunnerEndpoint {

    private final RunnerRepository runnerRepository;

    @GetMapping
    List<Runner> runners(){
        return runnerRepository.findAll();
    }

    @PostMapping
    Runner add(@RequestBody Runner runner){
        runnerRepository.add(runner);
        return runner;
    }
}

package at.nacs.bew4;

import at.nacs.bew4.domain.Runner;
import at.nacs.bew4.domain.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/winner")
@RequiredArgsConstructor
public class WinnerEndpoint {

    private final RunnerRepository runnerRepository;

    @GetMapping
    Runner getWinner(){
        return runnerRepository.findFastest().orElse(null);
    }
}

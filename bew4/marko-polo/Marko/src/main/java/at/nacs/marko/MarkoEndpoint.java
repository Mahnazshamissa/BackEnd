package at.nacs.marko;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
@RequiredArgsConstructor
public class MarkoEndpoint {
    private final Poloclient poloclient;

    @GetMapping("/{message}")
    String say(@PathVariable String message){
        return poloclient.post(message);
    }
}

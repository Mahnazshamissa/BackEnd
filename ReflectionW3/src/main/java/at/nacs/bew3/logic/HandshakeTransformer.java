package at.nacs.bew3.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class HandshakeTransformer {
    private final HandshakeLoader handshakeLoader;

    public List<String> transforme(Integer input) {
        Map<Integer, String> handshakes = handshakeLoader.getShake();
        return Stream.of(String.valueOf(input).split(""))
                .map(Integer::valueOf)
                .filter(handshakes::containsKey)
                .map(handshakes::get)
                .collect(Collectors.toList());
    }
}

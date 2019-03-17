package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MessageEncoder {
    private final MorseClient morseClient;

    public String encodeText(String message) {
        return Stream.of(message.split(""))
                .flatMap(Stream::of)
                .filter(e -> !e.isEmpty())
                .map(morseClient::post)
                .collect(Collectors.joining());
    }
}

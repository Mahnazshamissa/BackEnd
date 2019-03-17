package at.nacs.morse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Getter
@Setter
@ConfigurationProperties("morse")

public class MorseEncoder {

    private Map<String,String> morseCode;

    public String encodeToMorse(String letter){
        return morseCode.get(letter.toUpperCase());
    }
}

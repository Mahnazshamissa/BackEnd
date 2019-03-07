package at.nacs.bew3.exe06;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("liberary")
@Getter
@Setter
public class Liberary {

    private Map<String,Integer> book;
}

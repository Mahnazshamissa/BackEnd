package at.nacs.bew3.exe06;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("building")

public class SaunaLoader {

    private Sauna sauna;

}

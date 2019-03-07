package at.nacs.bew3.exe06;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ConfigurationProperties("dancer")
public class BallerinaLoader {

    private List<Ballerina> ballerinas;
}

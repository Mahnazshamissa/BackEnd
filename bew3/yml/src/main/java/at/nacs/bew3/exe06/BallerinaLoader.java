package at.nacs.bew3.exe06;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties("dancer")
public class BallerinaLoader {

    private List<Ballerina> ballerinas;
}

package at.nacs.bew3;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@ConfigurationProperties("shakes")
public class HandshakeLoader {

    private Map<Integer,String> shake;
}

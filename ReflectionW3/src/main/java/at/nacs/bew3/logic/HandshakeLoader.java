package at.nacs.bew3.logic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties("shake")
public class HandshakeLoader {

    private Map<Integer,String> shake;
}

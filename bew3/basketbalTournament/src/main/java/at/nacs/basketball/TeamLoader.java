package at.nacs.basketball;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Data
@ConfigurationProperties("tournament")
public class TeamLoader {

    private Set<BasketballTeam> teams;
}


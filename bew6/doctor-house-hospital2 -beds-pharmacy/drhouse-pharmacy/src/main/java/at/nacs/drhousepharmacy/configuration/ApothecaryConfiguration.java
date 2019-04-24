package at.nacs.drhousepharmacy.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("apothecary")
public class ApothecaryConfiguration {

    @Setter
    @Getter
    private Map<String, String> medicines;

    @Bean
    public Map<String, String> medicines() {
        return medicines;
    }
}

package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;

    //which url is the best in clean coding? first

    @Value("${accountancy.server.url}")
    private String url;

    //String url = "http://localhost:9005/patients";

    public Patient forward(Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}

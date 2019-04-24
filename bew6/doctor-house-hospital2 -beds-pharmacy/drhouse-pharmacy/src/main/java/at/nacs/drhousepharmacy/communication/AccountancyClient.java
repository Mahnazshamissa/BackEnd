package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;

    @Value("${accountancy.server.url}")
    private String url;

    public Patient forward(Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}

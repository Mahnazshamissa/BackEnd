package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class BedsOrPharmacyClient {

    private final RestTemplate restTemplate;

    public Patient forward(Patient patient) {
        if (patient.getDiagnosis() == "Lupus") {
            return restTemplate.postForObject("Bed", patient, Patient.class);
        }
        return restTemplate.postForObject("Pharmacy", patient, Patient.class);
    }
}

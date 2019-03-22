package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DiagnosesClient {

    private final RestTemplate restTemplate;

    private String patientUrl = "http://localhost:9002/patients";


    public Patient forward(Patient patient){
        return restTemplate.postForObject(patientUrl,patient,Patient.class);
    }

}

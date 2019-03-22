package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.domain.Patient;
import at.nacs.drhousediagnoses.logic.DrHouse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final DrHouse drHouse;

    @PostMapping
    Patient checkPatient(@RequestBody Patient patient) {
        Patient patientWithDiagnosis = drHouse.checkUp(patient);
        return patientWithDiagnosis;
    }

}

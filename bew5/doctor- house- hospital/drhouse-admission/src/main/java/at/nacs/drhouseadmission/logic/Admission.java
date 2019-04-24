package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Admission {

    private final DiagnosesClient diagnosesClient;

    public Patient admite(Patient patient) {
        UUID id = UUID.randomUUID();
        patient.setId(id.toString());
        diagnosesClient.forward(patient);
        return patient;
    }


}

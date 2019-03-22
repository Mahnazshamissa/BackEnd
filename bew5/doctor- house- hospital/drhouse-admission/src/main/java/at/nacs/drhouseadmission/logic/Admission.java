package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

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

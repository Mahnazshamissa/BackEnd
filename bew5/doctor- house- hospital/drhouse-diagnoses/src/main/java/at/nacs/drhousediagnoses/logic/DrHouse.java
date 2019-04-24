package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrHouse {

    public Patient checkUp(Patient patient) {
        String symptoms = patient.getSymptoms();
        if (isDiagnosisFound(symptoms)) {
            patient.setDiagnosis("the diagnosis is found");
            return patient;
        }
        patient.setDiagnosis("lupus");
        return patient;
    }

    private boolean isDiagnosisFound(String symptoms) {
        return true;
    }
}

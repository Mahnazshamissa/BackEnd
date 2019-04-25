package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.communication.AccountancyClient;
import at.nacs.drhousebeds.persistence.domain.Patient;
import at.nacs.drhousebeds.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Nurse {
    private final Map<String, String> treatments;
    private final PatientRepository repository;
    private final AccountancyClient accountancyClient;

    public Patient provideTheRightTreatment(Patient patient) {
        provideTreatment(patient);
        repository.save(patient);
        accountancyClient.forward(patient);
        return patient;
    }

    private void provideTreatment(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        String treatment = treatments.getOrDefault(diagnosis, "rest");
        patient.setTreatment(treatment);
    }

}

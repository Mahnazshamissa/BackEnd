package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientManager {

    private final PatientRepository patientRepository;

    public void savePatient(Patient patient) {
        if (patientRepository.existsByUuid(patient.getUuid())) {
            return;
        }
        patientRepository.save(patient);
    }
}

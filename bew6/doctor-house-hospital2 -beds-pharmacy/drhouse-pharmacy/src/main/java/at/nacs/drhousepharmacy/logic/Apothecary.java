package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Apothecary {

    private final Map<String, String> medicines;
    private final PatientRepository repository;
    private final AccountancyClient accountancyClient;

    public Patient provideTheRightMedicine(Patient patient){
        provideMedicine(patient);
        repository.save(patient);
        accountancyClient.forward(patient);
        return patient;
    }

    private void provideMedicine(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        String medicine = medicines.getOrDefault(diagnosis, "rest");
        patient.setMedicine(medicine);
    }
}

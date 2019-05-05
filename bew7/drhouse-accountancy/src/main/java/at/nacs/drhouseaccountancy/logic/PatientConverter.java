package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.dto.PatientDTO;
import org.springframework.stereotype.Service;

@Service
public class PatientConverter {
    public Patient convert(PatientDTO patientDTO) {
        return Patient.builder()
                .name(patientDTO.getName())
                .uuid(patientDTO.getId())
                .build();
    }

}

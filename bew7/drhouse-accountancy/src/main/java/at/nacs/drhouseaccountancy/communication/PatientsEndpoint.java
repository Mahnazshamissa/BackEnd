package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final Accountant accountant;

    @PostMapping
    Patient post(@RequestBody PatientDTO patientDTO) {
        return accountant.generateAnInvoiceWithTheCosts(patientDTO);
    }
}

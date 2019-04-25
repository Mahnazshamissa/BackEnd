package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoicesEndpoint {

    private final Accountant accountant;

    @GetMapping
    Invoice get(){
        return accountant. ;
    }

    @PutMapping
    Patient post(@RequestBody PatientDTO patientDTO) {
        return accountant.generateAnInvoiceWithTheCosts(patientDTO);
    }
}

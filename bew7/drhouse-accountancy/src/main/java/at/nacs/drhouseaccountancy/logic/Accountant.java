package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {

    private final PatientManager patientManager;
    private final InvoiceManager invoiceManager;
    private final PatientConverter converter;

    public void invoice(PatientDTO patientDTO) {
        Patient patient = converter.convert(patientDTO);
        patientManager.savePatient(patient);
        invoiceManager.createInvoice(patientDTO, patient);
    }

}

package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceManager {

    private final InvoiceRepository invoiceRepository;
    private final PricesManager pricesManager;

    public Invoice createInvoice(PatientDTO patientDTO, Patient patient) {
        Invoice invoice = Invoice.builder()
                .patient(patient)
                .kind(getKind(patientDTO))
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .provided(getProvided(patientDTO))
                .cost(calculateCosts(patientDTO))
                .paid(false)
                .timestamp(LocalDateTime.now())
                .build();
        invoiceRepository.save(invoice);
        return invoice;
    }

    private String getProvided(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return patientDTO.getTreatment();
        }
        return patientDTO.getMedicine();
    }

    private Kind getKind(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return Kind.TREATMENT;
        }
        return Kind.MEDICINE;
    }

    public Double calculateCosts(PatientDTO patientDTO) {
        String medicine = patientDTO.getMedicine();
        if (Objects.equals(medicine, null)) {
            String treatment = patientDTO.getTreatment();
            return pricesManager.calculate(treatment);
        }
        return pricesManager.calculate(medicine);
    }

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public void markAsPaid(Long id) {
        Optional<Invoice> oInvoice = invoiceRepository.findById(id);
        if (oInvoice.isEmpty()) {
            return;
        }
        Invoice invoice = oInvoice.get();
        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }


}

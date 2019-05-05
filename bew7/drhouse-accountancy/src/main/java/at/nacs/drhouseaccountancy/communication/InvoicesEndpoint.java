package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoicesEndpoint {

    private final InvoiceManager invoiceManager;

    @GetMapping
    List<Invoice> get(){
        return invoiceManager.findAllInvoices() ;
    }

    @PutMapping("/{id}/paid")
    void paid(@PathVariable Long id) {
        invoiceManager.markAsPaid(id);
    }
}

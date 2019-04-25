package at.nacs.drhouseaccountancy.persistence.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private String id;

    @ManyToOne
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private Kind kind;

    private String symptoms;

    private String diagnosis;

    private String provided; // ??(either the treatment given or the medicine suggested)

    private double cost;

    private boolean paid;

    private LocalDateTime timestamp;


}

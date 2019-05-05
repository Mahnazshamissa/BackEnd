package at.nacs.drhouseaccountancy.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    @Id
    @GeneratedValue
    private String id;

    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String medicine;


}

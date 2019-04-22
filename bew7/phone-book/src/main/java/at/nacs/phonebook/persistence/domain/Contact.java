package at.nacs.phonebook.persistence.domain;

import lombok.Data;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne(cascade= CascadeType.ALL)
    private Address address;

}

package at.nacs.ex4theenglishgentleman;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Cigar {

    private boolean lit;

    public void smoke() throws CigarWasNotLitException {
        if (!lit) {
            throw new CigarWasNotLitException();
        }
    }
}


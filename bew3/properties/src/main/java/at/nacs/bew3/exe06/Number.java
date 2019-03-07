package at.nacs.bew3.exe06;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Number {

    @Value("${number.amount}")
    private Integer amount;
}

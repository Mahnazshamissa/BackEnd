package at.nacs.bew3.exe06;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class Week {

    @Value("${week.days}")
    private List<String> days;
}

package at.nacs.bew3.exe06;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeekDaysApp {

    @Bean
    ApplicationRunner applicationRunner(Week day) {
        return args -> {
            List<String> days = day.getDays();
            System.out.println(days);
        };
    }

}

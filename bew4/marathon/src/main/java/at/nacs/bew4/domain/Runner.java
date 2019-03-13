package at.nacs.bew4.domain;

import lombok.Data;

import java.time.Duration;

@Data
public class Runner {

    private String name;
    private Duration time;
}

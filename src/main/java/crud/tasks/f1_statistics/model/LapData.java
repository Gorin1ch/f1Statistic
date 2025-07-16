package crud.tasks.f1_statistics.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;

@Data
@Entity
public class LapData {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Track track;

    @ManyToOne
    private Driver driver;

    private int lapNumber;
    private Long averageSpeed;

    private Duration sectorTime1;
    private Duration sectorTime2;
    private Duration sectorTime3;

    private Duration totalLapTime;
}

package crud.tasks.f1_statistics.dto.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
public class TrackDtoRequest{
    private String trackName;
    private String country;
    private String city;
    private Long lengthInMeters;
    private int turnCount;
}

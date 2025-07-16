package crud.tasks.f1_statistics.dto.response;


import crud.tasks.f1_statistics.dto.ResponseContract;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class TrackDtoResponse extends ResponseContract {
    private String trackName;
    private String country;
    private String city;
    private Long lengthInMeters;
    private int turnCount;
}

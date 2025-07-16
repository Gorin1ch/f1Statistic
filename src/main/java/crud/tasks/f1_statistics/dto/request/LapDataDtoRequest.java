package crud.tasks.f1_statistics.dto.request;


import lombok.Data;

@Data
public class LapDataDtoRequest {
    private Long driverId;
    private Long trackId;
    private int lapNumber;
    private Long averageSpeed;
    private Long sectorTime1;
    private Long sectorTime2;
    private Long sectorTime3;
}

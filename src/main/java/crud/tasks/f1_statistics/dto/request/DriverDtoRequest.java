package crud.tasks.f1_statistics.dto.request;

import lombok.Data;

@Data
public class DriverDtoRequest {
    private String driverName;
    private String team;
    private Long number;
}

package crud.tasks.f1_statistics.dto.response;

import crud.tasks.f1_statistics.dto.ResponseContract;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class DriverDtoResponse extends ResponseContract {
    private String driverName;
    private String team;
    private Long number;
}

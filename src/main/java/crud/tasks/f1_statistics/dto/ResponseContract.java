package crud.tasks.f1_statistics.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class ResponseContract {
    private Long id;
}

package crud.tasks.f1_statistics.service;


import crud.tasks.f1_statistics.dto.request.DriverDtoRequest;
import crud.tasks.f1_statistics.dto.response.DriverDtoResponse;

import java.util.List;

public interface DriverService {
    List<DriverDtoResponse> getAll();
    DriverDtoResponse getById(Long id);
    DriverDtoResponse save(DriverDtoRequest request);
    DriverDtoResponse create(DriverDtoRequest request);
}

package crud.tasks.f1_statistics.service;

import crud.tasks.f1_statistics.dto.request.TrackDtoRequest;
import crud.tasks.f1_statistics.dto.response.TrackDtoResponse;

import java.util.List;

public interface TrackService {
    List<TrackDtoResponse> getAll();
    TrackDtoResponse getById(Long id);
    TrackDtoResponse create(TrackDtoRequest request);

}

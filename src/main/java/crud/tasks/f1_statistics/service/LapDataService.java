package crud.tasks.f1_statistics.service;

import crud.tasks.f1_statistics.model.LapData;
import java.time.Duration;
import java.util.List;

public interface LapDataService {
    void save(LapData lapData);
    List<LapData> getByDriver(Long driverId);
    List<LapData> getByTrack(Long trackId);
    Duration getAverageLap(Long driverId);
}

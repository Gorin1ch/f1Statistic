package crud.tasks.f1_statistics.service;

import crud.tasks.f1_statistics.entity.LapData;
import crud.tasks.f1_statistics.repository.LapDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LapDataServiceImpl implements LapDataService {

    private final LapDataRepository repository;

    @Override
    public void save(LapData lapData){
        repository.save(lapData);
    }

    @Override
    public List<LapData> getByDriver(Long driverId){
        return repository.findByDriverId(driverId);
    }

    @Override
    public List<LapData> getByTrack(Long trackId){
        return repository.findByTrackId(trackId);
    }

    @Override
    public Duration getAverageLap(Long driverId){
        List<LapData> laps = repository.findByDriverId(driverId);
        if(laps.isEmpty()) return Duration.ZERO;
        return laps.stream()
                .map(LapData::getTotalLapTime)
                .reduce(Duration.ZERO, Duration::plus)
                .dividedBy(laps.size());
    }
}

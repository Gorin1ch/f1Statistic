package crud.tasks.f1_statistics.mapper;

import crud.tasks.f1_statistics.dto.request.LapDataDtoRequest;
import crud.tasks.f1_statistics.entity.Driver;
import crud.tasks.f1_statistics.entity.LapData;
import crud.tasks.f1_statistics.entity.Track;
import crud.tasks.f1_statistics.repository.DriverRepository;
import crud.tasks.f1_statistics.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class LapDataMapper {
    private final DriverRepository driverRepository;
    private final TrackRepository trackRepository;

    public LapData fromRequest(LapDataDtoRequest request){
        Driver driver = driverRepository.findById(request.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        Track track = trackRepository.findById(request.getTrackId())
                .orElseThrow(() -> new RuntimeException("Track not found"));

        Duration s1 = Duration.ofMillis(request.getSectorTime1());
        Duration s2 = Duration.ofMillis(request.getSectorTime2());
        Duration s3 = Duration.ofMillis(request.getSectorTime3());

        LapData lapData = new LapData();
        lapData.setDriver(driver);
        lapData.setTrack(track);
        lapData.setLapNumber(request.getLapNumber());
        lapData.setAverageSpeed(request.getAverageSpeed());
        lapData.setSectorTime1(s1);
        lapData.setSectorTime2(s2);
        lapData.setSectorTime3(s3);
        lapData.setTotalLapTime(s1.plus(s2).plus(s3));

        return lapData;
    }
}

package crud.tasks.f1_statistics.service;

import crud.tasks.f1_statistics.dto.request.TrackDtoRequest;
import crud.tasks.f1_statistics.dto.response.TrackDtoResponse;
import crud.tasks.f1_statistics.entity.Track;
import crud.tasks.f1_statistics.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;

    @Override
    public List<TrackDtoResponse> getAll(){
        return trackRepository.findAll()
                .stream()
                .map(
                        t -> TrackDtoResponse
                                .builder()
                                .trackName(t.getTrackName())
                                .country(t.getCountry())
                                .city(t.getCity())
                                .lengthInMeters(t.getLengthInMeters())
                                .turnCount(t.getTurnCount())
                                .build()
                )
        .collect(Collectors.toList());
    }

    @Override
    public TrackDtoResponse getById(Long id){
        Track track = trackRepository.findById(id).orElseThrow();

        return TrackDtoResponse.builder()
                .id(track.getId())
                .trackName(track.getTrackName())
                .country(track.getCountry())
                .city(track.getCity())
                .lengthInMeters(track.getLengthInMeters())
                .turnCount(track.getTurnCount())
                .build();
    }

    @Override
    public TrackDtoResponse create(TrackDtoRequest request){
        Track track = trackRepository.save(
                Track.builder()
                        .trackName(request.getTrackName())
                        .country(request.getCountry())
                        .city(request.getCity())
                        .lengthInMeters(request.getLengthInMeters())
                        .turnCount(request.getTurnCount())
                        .build()
        );

        return TrackDtoResponse.builder()
                .id(track.getId())
                .trackName(track.getTrackName())
                .country(track.getCountry())
                .city(track.getCity())
                .lengthInMeters(track.getLengthInMeters())
                .turnCount(track.getTurnCount())
                .build();
    }

}
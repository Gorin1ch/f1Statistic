package crud.tasks.f1_statistics.controller;


import crud.tasks.f1_statistics.dto.request.LapDataDtoRequest;
import crud.tasks.f1_statistics.mapper.LapDataMapper;
import crud.tasks.f1_statistics.entity.LapData;
import crud.tasks.f1_statistics.service.LapDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/laps")
@RequiredArgsConstructor
public class LapDataController {
    private final LapDataService service;
    private final LapDataMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody LapDataDtoRequest request){
        LapData lap = mapper.fromRequest(request);
        service.save(lap);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/driver/{id}")
    public List<LapData> getByDriver(@PathVariable Long id){
        return service.getByDriver(id);
    }

    @GetMapping("/track/{id}")
    public List<LapData> getByTrack(@PathVariable Long id){
        return service.getByTrack(id);
    }

    @GetMapping("/driver/{id}/average")
    public Duration getAverageLap(@PathVariable Long id) {
        return service.getAverageLap(id);
    }
}
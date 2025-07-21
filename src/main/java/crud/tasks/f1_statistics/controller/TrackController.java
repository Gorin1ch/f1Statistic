package crud.tasks.f1_statistics.controller;

import crud.tasks.f1_statistics.dto.request.TrackDtoRequest;
import crud.tasks.f1_statistics.dto.response.TrackDtoResponse;
import crud.tasks.f1_statistics.service.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tracks")
@RestController
@AllArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @GetMapping
    public ResponseEntity<List<TrackDtoResponse>> getAll(){
        return ResponseEntity.ok(trackService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackDtoResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(trackService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TrackDtoResponse> create(@RequestBody TrackDtoRequest trackDtoRequest){
        return ResponseEntity.ok(trackService.create(trackDtoRequest));
    }
}

package crud.tasks.f1_statistics.controller;


import crud.tasks.f1_statistics.dto.request.DriverDtoRequest;
import crud.tasks.f1_statistics.dto.response.DriverDtoResponse;
import crud.tasks.f1_statistics.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/driver")
public class DrvierController {
    private final DriverService driverService;

    @GetMapping
    public ResponseEntity<List<DriverDtoResponse>> getAll(){
        return ResponseEntity.ok(driverService.getAll());
    }

    @GetMapping
    public ResponseEntity<DriverDtoResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.getById(id));
    }

    @PostMapping
    public ResponseEntity<DriverDtoResponse> save(@Validated @RequestBody DriverDtoRequest request) {
        DriverDtoResponse response = driverService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<DriverDtoResponse> create(@RequestBody DriverDtoRequest driverDtoRequest) {
        return ResponseEntity.ok(driverService.create(driverDtoRequest));
    }
}

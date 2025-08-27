package crud.tasks.f1_statistics.service;

import crud.tasks.f1_statistics.dto.request.DriverDtoRequest;
import crud.tasks.f1_statistics.dto.response.DriverDtoResponse;
import crud.tasks.f1_statistics.entity.Driver;
import crud.tasks.f1_statistics.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;

    @Override
    public List<DriverDtoResponse> getAll(){
        return driverRepository.findAll()
                .stream()
                .map(
                        d -> DriverDtoResponse
                                .builder()
                                .driverName(d.getDriverName())
                                .team(d.getTeam())
                                .number(d.getNumber())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public DriverDtoResponse findDriverById(Long id){
        Driver driver = driverRepository.findById(id).orElseThrow();
            return DriverDtoResponse.builder()
                    .id(driver.getId())
                    .driverName(driver.getDriverName())
                    .number(driver.getNumber())
                    .build();
    }

    @Override
    public DriverDtoResponse create(DriverDtoRequest request){
        Driver driver = driverRepository.save(
            Driver.builder()
                    .driverName(request.getDriverName())
                    .team(request.getDriverName())
                    .number(request.getNumber())
                    .build()
        );

            return DriverDtoResponse.builder()
                    .id(driver.getId())
                    .driverName(driver.getDriverName())
                    .team(driver.getTeam())
                    .number(driver.getNumber())
                    .build();
    }

    @Override
    public DriverDtoResponse save(DriverDtoRequest request){
        Driver driver = Driver.builder()
                .driverName(request.getDriverName())
                .team(request.getTeam())
                .number(request.getNumber())
                .build();

        Driver saved = driverRepository.save(driver);

        return DriverDtoResponse.builder()
                .id(saved.getId())
                .driverName(saved.getDriverName())
                .team(saved.getTeam())
                .number(saved.getNumber())
                .build();
    }



}

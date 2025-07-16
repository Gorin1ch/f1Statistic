package crud.tasks.f1_statistics.repository;

import crud.tasks.f1_statistics.model.LapData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LapDataRepository extends JpaRepository<LapData, Long> {
    List<LapData> findByDriverId(Long driverId);
    List<LapData> findByTrackId(Long trackId);
}

package crud.tasks.f1_statistics.repository;

import crud.tasks.f1_statistics.entity.LapData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LapDataRepository extends JpaRepository<LapData, Long> {
    List<LapData> findByDriverId(Long driverId);
    List<LapData> findByTrackId(Long trackId);
}

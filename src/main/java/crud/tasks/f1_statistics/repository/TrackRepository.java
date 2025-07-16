package crud.tasks.f1_statistics.repository;

import crud.tasks.f1_statistics.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    Optional<Track> findById(Long trackId);
}

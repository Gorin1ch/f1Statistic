package crud.tasks.f1_statistics.repository;

import crud.tasks.f1_statistics.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {


}

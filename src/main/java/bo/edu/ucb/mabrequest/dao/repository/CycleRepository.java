package bo.edu.ucb.mabrequest.dao.repository;

import bo.edu.ucb.mabrequest.dao.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleRepository extends JpaRepository<Cycle, Long>{

    Cycle findFirstByOrderByCycleIdDesc();

}

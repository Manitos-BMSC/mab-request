package bo.edu.ucb.mabrequest.dao.repository;

import bo.edu.ucb.mabrequest.dao.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByCycleIdAndRequestState(Integer cycleId, String requestState);
    Request findOneById(Long Id);
}

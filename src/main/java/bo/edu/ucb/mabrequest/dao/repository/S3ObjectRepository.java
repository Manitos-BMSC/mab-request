package bo.edu.ucb.mabrequest.dao.repository;

import bo.edu.ucb.mabrequest.dao.S3Object;
import org.springframework.data.jpa.repository.JpaRepository;

public interface S3ObjectRepository extends JpaRepository<S3Object, Long> {
}

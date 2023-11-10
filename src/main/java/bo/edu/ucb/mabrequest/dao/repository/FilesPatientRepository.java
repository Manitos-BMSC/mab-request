package bo.edu.ucb.mabrequest.dao.repository;

import bo.edu.ucb.mabrequest.dao.FilesPatient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilesPatientRepository extends JpaRepository<FilesPatient, Long>{
    List<FilesPatient> findAllByPacientId(Integer idPatient);
}

package bo.edu.ucb.mabrequest.dao.repository;

import bo.edu.ucb.mabrequest.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findOneById(Integer patientId);

}

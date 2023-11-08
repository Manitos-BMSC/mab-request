package bo.edu.ucb.mabrequest.dao.repository;

import bo.edu.ucb.mabrequest.dao.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

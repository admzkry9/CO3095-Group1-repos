package jobAdvertising.repository;

import jobAdvertising.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepo extends JpaRepository<Employer, Long> {
}

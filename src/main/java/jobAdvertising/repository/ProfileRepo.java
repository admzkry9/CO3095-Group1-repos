package jobAdvertising.repository;

import jobAdvertising.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
    // Additional methods can be added here if needed
}

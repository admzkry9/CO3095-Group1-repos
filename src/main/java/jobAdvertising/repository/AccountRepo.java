package jobAdvertising.repository;


import jobAdvertising.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    // Additional methods can be added here if needed
}


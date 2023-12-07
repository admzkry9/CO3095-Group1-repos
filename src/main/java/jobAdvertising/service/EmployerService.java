package jobAdvertising.service;

import jobAdvertising.domain.Employer;
import jobAdvertising.repository.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService {

    private final EmployerRepo employerRepository;

    @Autowired
    public EmployerService(EmployerRepo employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<Employer> findAllEmployers() {
        return employerRepository.findAll();
    }

    public Employer findEmployerById(Long id) {
        return employerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void initializeEmployers() {
        Employer employer1 = new Employer();
        employer1.setCompanyName("ABC Company");
        employer1.setContactEmail("abc@example.com");
        employer1.setContactName("John Doe");
        employer1.setContactPhone("123-456-7890");

        Employer employer2 = new Employer();
        employer2.setCompanyName("XYZ Corporation");
        employer2.setContactEmail("xyz@example.com");
        employer2.setContactName("Jane Smith");
        employer2.setContactPhone("987-654-3210");

        employerRepository.save(employer1);
        employerRepository.save(employer2);
    }
}

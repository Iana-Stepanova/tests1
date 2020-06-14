package ua.com.univerpulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.univerpulse.entities.Customer;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

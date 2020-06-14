package ua.com.univerpulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.univerpulse.entities.Customer;
import ua.com.univerpulse.entities.Payment;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}

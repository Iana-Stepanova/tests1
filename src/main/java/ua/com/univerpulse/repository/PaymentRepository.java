package ua.com.univerpulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.univerpulse.entities.Customer;
import ua.com.univerpulse.entities.Payment;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByPaymentAmountLessThan(Double amount);

    List<Payment> findByCustomerIdentificationAndPaymentAmountAndPaymentDateAndChannel
            (Integer customerID, Double paymentAmount, LocalDateTime paymentDate, String channel);

    List<Payment> findByCustomerIdentificationAndPaymentAmountAndChannel
            (Integer customerID, Double paymentAmount, String channel);
}

package ua.com.univerpulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.univerpulse.entities.Customer;
import ua.com.univerpulse.entities.projections.TotalAmounts;

import java.util.List;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query (value = "SELECT w.CUSTOMERID, q.NAME as CustomerName, SUM(w.PAYMENTAMOUNT) " +
            "As TotalPaymentAmount FROM CUSTOMERS q join PAYMENTS w on q.ID=w.CUSTOMERID" +
            " group by w.CUSTOMERID, q.NAME" +
            " Having SUM(w.PAYMENTAMOUNT)<:pamount", nativeQuery = true)
    List<TotalAmounts> selectCustomerAmounts(@Param("pamount") Double amount);
}

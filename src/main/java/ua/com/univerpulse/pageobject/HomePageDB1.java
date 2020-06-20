package ua.com.univerpulse.pageobject;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.univerpulse.entities.Customer;
import ua.com.univerpulse.entities.Payment;
import ua.com.univerpulse.services.CustomerService;
import ua.com.univerpulse.services.PaymentService;

import java.util.List;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
@Log4j2
@Component
public class HomePageDB1 {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PaymentService paymentService;

    public void customerLog(){
        List<Customer> customerSave = customerService.findAllCustomer();
        log.warn(customerSave);
    }

    public void paymentLog(Double amount){
        List<Payment> paymentSave = paymentService.findAllPayment(amount);
        log.warn(paymentSave);
    }
}

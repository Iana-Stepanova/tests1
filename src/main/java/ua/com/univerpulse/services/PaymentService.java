package ua.com.univerpulse.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.univerpulse.entities.Customer;
import ua.com.univerpulse.entities.Payment;
import ua.com.univerpulse.repository.CustomerRepository;
import ua.com.univerpulse.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */

@Log4j2
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

//    public void metod1() {
//
//      log. warn(customerRepository.findAll());
//
//    }
    //   <other repositories needed>

    public List<Payment> findAllPayment(Double amount) {
        List<Payment> res = paymentRepository.findByPaymentAmountLessThan(amount);
        assertFalse(res.isEmpty(), "Is empty");
        return res;
    }

    //    public Boolean findPaymentParam(Integer customerID, Double paymentAmount, LocalDateTime paymentDate, String channel) {
//        List<Payment> res = paymentRepository.findByCustomerIdentificationAndPaymentAmountAndPaymentDateAndChannel(customerID, paymentAmount, paymentDate, channel);
//    //assertFalse(res.isEmpty(), "Is empty");
//        return !res.isEmpty();
//    }
    public Boolean findPaymentParam(Integer customerID, Double paymentAmount, String channel) {
        List<Payment> res = paymentRepository.findByCustomerIdentificationAndPaymentAmountAndChannel(customerID, paymentAmount, channel);

        return !res.isEmpty();
    }

//    public ResultType methodOne(String param) {
//        ResultType res = entityClassNameRepository.selectSomething(param);
//        assertSomething(res);
//        applySomeLogic(res);
//        return res;
//        }}


}

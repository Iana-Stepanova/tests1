package ua.com.univerpulse.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.univerpulse.entities.Customer;
import ua.com.univerpulse.repository.CustomerRepository;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */

@Log4j2
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void metod1() {

      log. warn(customerRepository.findAll());

    }
    //   <other repositories needed>

//        public ResultType methodOne(String param) {
//            ResultType res = entityClassNameRepository.selectSomething(param);
//            assertSomething(res);
//            applySomeLogic(res);
//            return res;
//        }}
}

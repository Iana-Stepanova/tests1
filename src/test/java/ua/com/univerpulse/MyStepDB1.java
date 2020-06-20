package ua.com.univerpulse;

import io.cucumber.java8.En;
import ua.com.univerpulse.pageobject.HomePageDB1;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */


public class MyStepDB1 implements En {
    private HomePageDB1 homePageDB1;

    public MyStepDB1() {
        Before(() -> {
            SpringSelenide.getInstance();
            homePageDB1=SpringSelenide.createBean(HomePageDB1.class);
        });

        When("^Retrieve information about all payments with amount less than (\\d+) given amount$", (Double amount) -> {
            homePageDB1.paymentLog(amount);
        });
        Then("^Print all information in the log$", ()-> {

        });


    }
}

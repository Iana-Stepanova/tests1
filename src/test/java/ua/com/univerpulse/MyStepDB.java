package ua.com.univerpulse;

import com.codeborne.selenide.Configuration;
import io.cucumber.java8.En;
import ua.com.univerpulse.pageobject.HomePageDB1;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */


public class MyStepDB implements En {
    private HomePageDB1 homePageDB1;

    public MyStepDB() {
        Before(() -> {
            SpringSelenide.getInstance();
            homePageDB1=SpringSelenide.createBean(HomePageDB1.class);
        });


        When("^Retrieve information about all customers from DB$", () -> {
            homePageDB1.customerLog();
        });

    }
}

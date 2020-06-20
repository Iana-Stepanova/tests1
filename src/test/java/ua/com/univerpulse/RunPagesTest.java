package ua.com.univerpulse;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * For development purposes
 *
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for qactoyotaautomation project.
 */
//@formatter:off
@CucumberOptions(strict = true,
        plugin = {"pretty"
        , "html:target/features-report/qacToyotaAuto"
        , "json:target/cucumber_report/cucumber.json"
}
        , features = {"src/test/resources/features"}
        , glue = {"ua/com/univerpulse"}
        , tags = {"@Test2"}
)
@RunWith(Cucumber.class)
public class RunPagesTest   {}

package ua.com.univerpulse;

import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Selenide for Spring extension to create page objects as beans
 */
@Log4j2
public class SpringSelenide extends Selenide {
    private static SpringSelenide instance;
    private final ApplicationContext context;

    public static synchronized SpringSelenide getInstance() {
        if (instance == null) {
            instance = new SpringSelenide();
        }
        return instance;
    }

    private SpringSelenide() {
        context = new AnnotationConfigApplicationContext(Configurator.class);
    }

    /* the method is static to override parent one */
    public static <P> P page(Class<P> pageObjectClass) {
        try {
            // here is the trick - we are creating object as Selenide PageObject
            // and Spring bean in the same time
            return page(getInstance()
                    .context.getBean(pageObjectClass.getSimpleName(), pageObjectClass));
        } catch (Exception e) {
             log.error("Failed to create new instance of {}", pageObjectClass);
            log.catching(e);
            return null;
        }
    }
}

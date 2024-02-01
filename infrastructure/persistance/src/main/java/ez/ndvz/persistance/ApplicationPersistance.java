package ez.ndvz.persistance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ez.ndvz.domain")
public class ApplicationPersistance {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationPersistance.class, args);
    }

}

package ez.ndvz.persistance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ez.ndvz.core.domain","ez.ndvz"})
//@ConfigurationProperties(prefix = "spring.datasource")
public class ApplicationPersistance {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationPersistance.class, args);
    }

}

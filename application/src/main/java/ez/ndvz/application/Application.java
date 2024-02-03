package ez.ndvz.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan({"ez.ndvz","ez.ndvz.persistance"})
//@EnableConfigurationProperties(ApplicationPersistance.class)
@ComponentScan(basePackages = {"ez.ndvz","ez.ndvz.persistance","ez.ndvz.persistance.adapter"})
@EntityScan(basePackages = {"ez.ndvz.persistance"})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

package ez.ndvz.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan({"ez.ndvz","ez.ndvz.persistance"})
//@EnableConfigurationProperties(ApplicationPersistance.class)
@ComponentScan(basePackages = {"ez.ndvz","ez.ndvz.persistance","ez.ndvz.persistance.adapter","ez.ndvz.persistance.entity"})
@EntityScan(basePackages = {"ez.ndvz.persistance.entity"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

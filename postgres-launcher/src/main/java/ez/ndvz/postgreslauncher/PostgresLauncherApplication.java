package ez.ndvz.postgreslauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ez.ndvz.persistance")
public class PostgresLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresLauncherApplication.class, args);
	}

}

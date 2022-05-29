package tw.lwl.mybot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MybotApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybotApplication.class, args);
    }

}

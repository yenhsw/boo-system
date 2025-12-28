package boo_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "boo_core",
                "boo_security_starter"
        }
)
public class BooCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooCoreApplication.class, args);
    }
}

package es.code.urjc.ibercomponents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class IberComponentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IberComponentsApplication.class, args);
    }

}

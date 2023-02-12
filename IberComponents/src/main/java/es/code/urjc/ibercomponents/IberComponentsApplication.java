package es.code.urjc.ibercomponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IberComponentsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IberComponentsApplication.class, args);
    }

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception
    {
        Product product= new Product("RTX 2060", "Tarjeta Grafica Nvidia RTX 2060, super potente ", 3.5, 500, "Potencia");
        productRepository.save(product);
    }
}

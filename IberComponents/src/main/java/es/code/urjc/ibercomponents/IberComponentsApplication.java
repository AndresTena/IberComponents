package es.code.urjc.ibercomponents;

import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.repositories.ProductRepository;
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

        Product product= new Product("Gigabyte GeForce RTX 2060 OC 6GB GDDR6",
                "El sistema de refrigeración WINDFORCE 2X cuenta con 2 ventiladores de cuchilla exclusivos de 100 mm, ventilador alterno, 2 tubos de calor de cobre compuesto GPU de " +
                        "contacto directo y ventilador activo 3D, que entregan una disipación de calor efectiva."
                      ,
                    3.5, 500,
                "Desarrollado por GeForce RTX 2060\n" +
                "Integrado con 6GB GDDR6 interfaz de memoria de 192 bits\n" +
                "Sistema de enfriamiento WINDFORCE 2X con ventiladores alternativos\n" +
                "Ventiladores de cuchilla únicos de 90mm\n" +
                "Placa posterior de protección\n" +
                "Reloj de núcleo 1755 MHz (Tarjeta de referencia: 1680 MHz)");
        productRepository.save(product);



        Product product2= new Product("AMD Ryzen 5 5500 3.6GHz Box",
                "Los procesadores para juegos mejor valorados del mundo se llaman AMD Ryzen™ Serie 5000.\n" +
                        "\n" +
                        "Cuando cuentas con la arquitectura de procesadores de escritorio más avanzada del mundo para jugadores y creadores de contenido, las posibilidades son infinitas. " +
                        "Ya sea que juegues los juegos más recientes, diseñes el próximo rascacielos o proceses datos, necesitas un procesador poderoso que pueda dar"
                , 3.5, 500,
                "Plataforma: Computadora de escritori"

                        );
        productRepository.save(product2);
    }
}

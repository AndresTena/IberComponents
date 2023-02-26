package es.code.urjc.ibercomponents;

import es.code.urjc.ibercomponents.entities.Order;
import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.repositories.OrderRepository;
import es.code.urjc.ibercomponents.repositories.ProductRepository;
import es.code.urjc.ibercomponents.repositories.ShoppingCartRepository;
import es.code.urjc.ibercomponents.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
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
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

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
                "Reloj de núcleo 1755 MHz (Tarjeta de referencia: 1680 MHz)", true);
        productRepository.save(product);



        Product product2= new Product("AMD Ryzen 5 5500 3.6GHz Box",
                "Los procesadores para juegos mejor valorados del mundo se llaman AMD Ryzen™ Serie 5000.\n" +
                        "\n" +
                        "Cuando cuentas con la arquitectura de procesadores de escritorio más avanzada del mundo para jugadores y creadores de contenido, las posibilidades son infinitas. " +
                        "Ya sea que juegues los juegos más recientes, diseñes el próximo rascacielos o proceses datos, necesitas un procesador poderoso que pueda dar"
                , 3.5, 84,
                "Plataforma: Computadora de escritorio", true
                        );


        Product product3= new Product("Gigabyte B560M DS3H V2",
                "Placa base Intel® B560 ultra duradera con VRM digital directo de 6 + 2 fases, diseño PCIe 4.0 * complet" +
                        "o, PCIe 4.0 M.2," +
                        " LAN para juegos GIGABYTE 8118, audio HD de 8 canales con tapas de audio, USB TYPE-C®, RGB FUSION 2." +
                        "0 , Q-Flash Plus, 3.5, 84,",0.0,92.99,
                "Admite procesadores Intel® Core ™ Series de 11.a y 10.a generación\n" +
                        "DDR4 sin búfer no ECC de doble canal, 4 DIMM\n" +
                        "Solución VRM digital directa de 6 + 2 fases con MOSFET de bajo RDS (activado)\n" +
                        "Doble ultrarrápido NVMe PCIe 4.0 / 3.0 * x4 M.2\n" +
                        "LAN para juegos 8118 exclusiva de GIGABYTE con gestión de ancho de banda", true
        );

        productRepository.save(product2);
        productRepository.save(product3);
        ShoppingCart shoppingCart = new ShoppingCart(1);

        User admin = new User(1,"admin", "admin", shoppingCart,true, "a.delgadog.2019@alumnos.urjc.es", 5000 );

        Order order = new Order(1);
        orderRepository.save(order);
        userRepository.save(admin);
        shoppingCartRepository.save(shoppingCart);
    }
}

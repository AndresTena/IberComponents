package es.code.urjc.ibercomponents;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Controller
public class DataBaseInitializer implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
/*
	@PostConstruct
	public void init()throws IOException, URISyntaxException
	{
		String imageRoute = "assets/";
		Product producto1 = new Product("RTX2060", "Description", 3.2, 160, "GraficaRTX", imageRoute + "logo.png");
		
		productRepository.save(producto1);
	}
*/
	@Override
	public void run(String... args) throws Exception {

		String imageRoute = "assets/";
		Product producto1 = new Product("RTX2060", "Description", 3.2, 160, "GraficaRTX", imageRoute + "logo.png");

		productRepository.save(producto1);
	}
}

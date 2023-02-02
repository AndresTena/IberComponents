package es.code.urjc.ibercomponents;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;

@Service
public class DataBaseInitializer {
	
	private ProductRepository productRepository;
	
	public void init()throws IOException, URISyntaxException{
		String imageRoute = "assets/";
		Product producto1 = new Product("RTX2060", "Description", 3.2, 160, "GraficaRTX", imageRoute + "logo.png");
		
		productRepository.save(producto1);
	}
	
}

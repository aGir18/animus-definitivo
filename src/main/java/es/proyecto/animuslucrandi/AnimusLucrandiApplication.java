package es.proyecto.animuslucrandi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:config/jpa-config.xml"})
public class AnimusLucrandiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimusLucrandiApplication.class, args);
	}

}

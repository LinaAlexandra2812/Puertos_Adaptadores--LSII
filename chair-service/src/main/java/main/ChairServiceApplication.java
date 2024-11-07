package main;

import domain.model.Chair;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChairServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChairServiceApplication.class, args);
        
        Chair chair1 = new Chair("prueba1", "prueba1", "prueba@gmail.com");
        Chair chair2 = new Chair("prueba2", "prueba2", "prueba2@gmail.com" );
    }

}

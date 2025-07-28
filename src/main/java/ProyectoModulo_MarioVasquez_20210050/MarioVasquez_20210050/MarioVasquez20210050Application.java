package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarioVasquez20210050Application {

	public static void main(String[] args) {
		//Craga variables del .env al sistema
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(MarioVasquez20210050Application.class, args);
	}

}

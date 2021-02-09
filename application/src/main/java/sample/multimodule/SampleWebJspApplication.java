package sample.multimodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author Aife Munshi
 *
 */
@EnableTransactionManagement
@SpringBootApplication
public class SampleWebJspApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleWebJspApplication.class, args);

	}
	
}

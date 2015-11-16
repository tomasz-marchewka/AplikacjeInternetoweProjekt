package pl.prz.aip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.prz.aip.dao.DzialRepository;
import pl.prz.aip.model.Dzial;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	DzialRepository dzialRepo;

	@Override
	public void run(String... arg0) throws Exception {
		Dzial d1 = new Dzial();
		d1.setNazwa("Robienie dzia³");
		d1.setOpis("Dzia³ robienia dzia³");
		dzialRepo.save(d1);
		for (Dzial dzial : dzialRepo.findAll()) {
			System.out.println(dzial.getOpis());
		}

	}
}
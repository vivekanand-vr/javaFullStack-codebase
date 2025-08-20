package in.ineuron;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;
import in.ineuron.type.ResultView;

@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		List<ResultView> listVaccines = service.searchVaccineByStartPrice(500.0);
		listVaccines.forEach(vaccine -> {
			System.out.println(
					vaccine.getClass().getName() + " " + Arrays.toString(vaccine.getClass().getDeclaredMethods()));
			System.out.println(vaccine.getName() + " " + vaccine.getCountry());
		});
		((ConfigurableApplicationContext) factory).close();
	}
}

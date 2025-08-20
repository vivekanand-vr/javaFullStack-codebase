package in.ineuron.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = "in/ineuron/commons/application.properties")
public class PersistenceConfig {

	static {
		System.out.println("PersistenceConfig.class file is loading...");
	}

	public PersistenceConfig() {
		System.out.println("PersistenceConfig:: Zero param constructor...");
	}

	@Autowired
	private Environment env;

	@Bean(value = "dataSource")
	public HikariDataSource getDS() {
		System.out.println("PersistenceConfig.getDS()");
		System.out.println("Implementation class name is :: "+env.getClass().getName());
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setMinimumIdle(Integer.parseInt(env.getProperty("jdbc.minimumIdle")));
		dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("jdbc.maximumPoolSize")));
		dataSource.setConnectionTimeout(Integer.parseInt(env.getProperty("jdbc.connectionTimeOut")));
		return dataSource;
	}

}

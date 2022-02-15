package demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	@Autowired
	private Environment env;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public DataSource securityDataSource() {

		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));

			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.user"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));

			securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));

			securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));

			securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));

			securityDataSource.setMaxIdleTimeExcessConnections(getIntProperty("connection.pool.maxIdleTime"));

		} catch (PropertyVetoException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return securityDataSource;

	}

	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		return Integer.parseInt(propVal);
	}

}

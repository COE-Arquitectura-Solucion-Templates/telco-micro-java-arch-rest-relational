package ${groupId}.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;


@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard

public class {$artifactId} extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		
		 builder.up()
         .withDetail("app", "Mobile app ws")
         .withDetail("sucess", "OK");
		 
	}	

	public static void main(String[] args) {
		SpringApplication.run({$artifactId}.class, args);
	}	

	@Bean(name = "hystrixRegistrationBean")
	public ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(
	            new HystrixMetricsStreamServlet(), "/hystrix.stream");
	    registration.setName("hystrixServlet");
	    registration.setLoadOnStartup(1);
	    return registration;
	}
	
}

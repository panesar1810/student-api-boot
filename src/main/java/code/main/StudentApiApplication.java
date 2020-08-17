package code.main;

import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EntityScan("code.entity")
@ComponentScan("code.response")
@EnableJpaRepositories("code.repository")
public class StudentApiApplication {
	
	public static void main(String[] args) {
		System.setProperty("spring.main.lazy-initialization", "true");
		SpringApplication.run(StudentApiApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	   return new WebMvcConfigurerAdapter() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/students").allowedOrigins("http://localhost:9000");
	      }    
	   };
	}
	
	@Bean
	public PhysicalNamingStrategy physical() {
	    return new PhysicalNamingStrategyStandardImpl();
	}
	 
	@Bean
	public ImplicitNamingStrategy implicit() {
	    return new ImplicitNamingStrategyLegacyJpaImpl();
	}
	
}

package administradorUsers;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import administradorUsers.filters.JWTAuthorizationFilter;



@SpringBootApplication
public class Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
		
	}
	
	
	
	 @PostConstruct
	    public void init(){
	      TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
	    }
	

}

package administradorUsers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import administradorUsers.filters.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.cors()
		 .and()
		 .csrf().disable()
		 .authorizeRequests()	
		 .antMatchers(HttpMethod.POST, "/login/**").permitAll()
		 .antMatchers(HttpMethod.POST, "/usuario/**").permitAll()
		 .antMatchers(HttpMethod.GET, "/usuario/**").permitAll()
		 //.antMatchers(HttpMethod.POST, "/usuario/login").permitAll()
		 .antMatchers(HttpMethod.GET, "/files/**").permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class) ;
          

	} 
	
}

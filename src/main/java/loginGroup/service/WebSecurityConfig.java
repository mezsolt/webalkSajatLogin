package loginGroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement()/*.enableSessionUrlRewriting(true)*/.maximumSessions(5);
		http.authorizeRequests().antMatchers("/user/postuser").permitAll().and().authorizeRequests().antMatchers("/user/getuser").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.userDetailsService(userDetailsService);
	    auth.inMemoryAuthentication().withUser("user2").password("pw2").roles("USER");
	}

	
	//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //String name = auth.getName(); //get logged in username

	
}

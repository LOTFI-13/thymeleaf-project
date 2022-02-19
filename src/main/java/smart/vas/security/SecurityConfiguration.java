package smart.vas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import smart.vas.service.UserService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	 @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	 
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	        auth.setPasswordEncoder(passwordEncoder());
	        auth.setUserDetailsService(userService);
	        

	        return auth;
	    }
	 
	 @Bean
	 public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	     return new MySimpleUrlAuthenticationSuccessHandler();
	 }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
	                "/assets/**",
	                "/assets/js/**",
	                "/assets/images/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successHandler(myAuthenticationSuccessHandler())
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
               
    }

}

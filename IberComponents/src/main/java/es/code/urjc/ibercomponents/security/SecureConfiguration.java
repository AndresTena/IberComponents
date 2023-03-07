package es.code.urjc.ibercomponents.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecureConfiguration extends WebSecurityConfigurerAdapter
{
    @Value("${security.user}")
    private String user;

    @Value("${security.encodedPassword}")
    private String encodedPassword;

    
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = encoder.encode("pass");
        auth.inMemoryAuthentication().withUser("user").password(encodedPassword).roles("USER");
    }


    protected void configure(HttpSecurity http) throws Exception
    {

        //paginas publicas
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/shoppingCart").permitAll();
        http.authorizeRequests().antMatchers("/orders").permitAll();
        http.authorizeRequests().antMatchers("/").permitAll();

        //paginas privadas
        http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/newProduct").hasAnyRole("ADMIN");


        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginError");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

        // Disable CSRF at the moment
        http.csrf().disable();
    }

}
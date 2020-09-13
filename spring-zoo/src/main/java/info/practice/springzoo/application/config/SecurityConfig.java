package info.practice.springzoo.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.cert.Extension;

@Configuration  // adnotacja - ze jest to klasa konfig aplikacji
@EnableWebSecurity // wlaczy nam to security dzieki tej adnotacji
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password(passwordEncoder().encode("user1Pass"))
                .authorities("ROLE_USER");
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("adminPass"))
                .authorities("ROLE_ADMIN");
    }

    //password encoder - sluzy tylko do tego zeby mozna bylo zakodowac haslo
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //metoda konfiguracyjna

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//wyl CSRF
                .authorizeRequests()  //autoryzuj zapytania i ponizej wypisujemy jakie zapytania maja byc uzupelnione
                .antMatchers("/securityNone").permitAll()
                .antMatchers(HttpMethod.POST,"/animals").hasAuthority("ROLE_ADMIN") //dla metody Post z endpointem animals - to chcemy zeby tylko bylo realizowane przez role admin
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }
}
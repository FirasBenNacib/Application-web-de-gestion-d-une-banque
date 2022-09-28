package com.axeane.configuration;

import com.axeane.services.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private UtilisateurDetailsService appUserDetailsService;

    private static final String[] AUTH_LIST = {
            "/login", "/test/**" , "/agences" , "/agences/{agenceId}/numerocomptes", "/numerocomptes/{numerocompteId}/transactions"
    };

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests().antMatchers(AUTH_LIST).permitAll().
                antMatchers("agences**").permitAll().
                //tesing authorities
                        antMatchers("/Admin/**").hasAuthority("admin").antMatchers("/Profile/**").authenticated()
                .antMatchers("/Data/**").authenticated()
                .anyRequest().authenticated().and().httpBasic().and().


                exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();


        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("password"))
                .roles("user");
        auth.userDetailsService(appUserDetailsService);

    }


    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();//no password encoder for testing purposes
    }
}





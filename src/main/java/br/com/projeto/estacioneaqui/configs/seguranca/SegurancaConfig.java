package br.com.projeto.estacioneaqui.configs.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.projeto.estacioneaqui.configs.seguranca.services.AutenticacaoService;
import br.com.projeto.estacioneaqui.configs.seguranca.services.TokenService;
import br.com.projeto.estacioneaqui.services.UsuarioService;

@EnableWebSecurity
@Configuration
@Profile(value = {"prod", "test"})
public class SegurancaConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
		.antMatchers(HttpMethod.GET, "/cliente").permitAll()
		.antMatchers(HttpMethod.GET, "/cliente/*").permitAll()
		.antMatchers(HttpMethod.GET, "/movimentacao").permitAll()
		.antMatchers(HttpMethod.GET, "/movimentacao/*").permitAll()
		.antMatchers(HttpMethod.GET, "/servico").permitAll()
		.antMatchers(HttpMethod.GET, "/servico/*").permitAll()
		.antMatchers(HttpMethod.GET, "/vaga").permitAll()
		.antMatchers(HttpMethod.GET, "/vaga/*").permitAll()
		.antMatchers(HttpMethod.GET, "/veiculo").permitAll()
		.antMatchers(HttpMethod.GET, "/veiculo/*").permitAll()
		.anyRequest().authenticated()
		.and().cors()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioService), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	        .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
}

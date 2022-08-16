package com.emlcoding.springboot.backend.apirest.auth;


/*
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration

public class SpringSecurityConfig {
	
	@Autowired
	private UserDetailsService usuarioService;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
        EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
            EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
        contextSourceFactoryBean.setPort(0);
        return contextSourceFactoryBean;
    }

	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		return auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder()).and().build();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		return http.build();
	}
}
*/
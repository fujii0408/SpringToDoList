package todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web)throws Exception {
//		セキュリティを適用しない
		web.ignoring()
			.antMatchers("/webjars/**")
			.antMatchers("/css/**")
			.antMatchers("/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		ログイン画面の直リンクは許可し、それ以外の直リンクを無効にする
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated();

		http.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/login")
			.failureUrl("/error")//正しい？
			.usernameParameter("userName")
			.passwordParameter("password")
			.defaultSuccessUrl("/list", true);

		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		パスワードをハッシュ化して、認証
		PasswordEncoder encoder = passwordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}
}

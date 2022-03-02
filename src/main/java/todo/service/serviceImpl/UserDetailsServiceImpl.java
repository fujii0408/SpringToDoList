package todo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import todo.model.User;
import todo.service.LoginService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginService loginService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User loginUser = loginService.getLoginUser(userName);

		if(loginUser == null) {
			throw new UsernameNotFoundException("user not found");
		}

//		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(authority);
//
//		UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(loginUser.getUsername(), loginUser.getPassword(), authorities);

		return loginUser;
	}

}

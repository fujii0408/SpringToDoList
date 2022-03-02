package todo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.model.User;
import todo.repository.UserMapper;
import todo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper mapper;

	@Override
	public User getLoginUser(String userName) {
		return mapper.findLoginUser(userName);
	}

	@Override
	public int countRegisteredUser(String userName, String password) {
		return mapper.findUser(userName, password);
	}
}

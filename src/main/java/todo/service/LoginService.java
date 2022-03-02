package todo.service;

import org.springframework.stereotype.Service;

import todo.model.User;

@Service
public interface LoginService {

	public User getLoginUser(String userName);

	public int countRegisteredUser(String userName, String password);
}

package todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import todo.model.Todo;
import todo.model.User;

@Service
public interface RegisterService {
	public void register(Todo todo);

	public List<User> findUsers();

	public int countExistUser(String userId);
}

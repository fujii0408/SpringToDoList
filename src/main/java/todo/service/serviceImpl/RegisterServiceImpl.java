package todo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.model.Todo;
import todo.model.User;
import todo.repository.TodoMapper;
import todo.repository.UserMapper;
import todo.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private TodoMapper listMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public void register(Todo todo) {
		listMapper.insertOne(todo);
	}

	@Override
	public List<User> findUsers() {
		return userMapper.findUsers();
	}

	@Override
	public int countExistUser(String userId) {
		return userMapper.countExistUser(userId);
	}

}

package todo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.model.Todo;
import todo.repository.TodoMapper;
import todo.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	TodoMapper todoMapper;

	@Override
	public Todo findByTodoId(String todoId) {
		return todoMapper.findByTodoId(todoId);

	}

	@Override
	public void updateOne(Todo todo) {
		todoMapper.updateOne(todo);
	}

}

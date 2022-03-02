package todo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.model.Todo;
import todo.repository.TodoMapper;
import todo.service.FinishService;

@Service
public class FinishServiceImpl implements FinishService {

	@Autowired
	TodoMapper todoMapper;

	@Override
	public void finishOne(Todo todo) {
		todoMapper.finishOne(todo);
	}

	@Override
	public Todo findFinishedDate(String todoId) {
		return todoMapper.findFinishedDate(todoId);
	}

	@Override
	public void unfinishOne(String todoId) {
		todoMapper.unfinishOne(todoId);

	}

}

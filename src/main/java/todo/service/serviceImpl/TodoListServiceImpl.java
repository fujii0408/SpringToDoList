package todo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.model.Todo;
import todo.repository.TodoMapper;
import todo.service.TodoListService;

@Service
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	private TodoMapper todoMapper;

	@Override
	public List<Todo> findTodoList(){
		return todoMapper.findTodoList();
	}
}

package todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import todo.model.Todo;

@Service
public interface TodoListService {
	public List<Todo> findTodoList();
}

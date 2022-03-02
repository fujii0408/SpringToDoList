package todo.service;

import org.springframework.stereotype.Service;

import todo.model.Todo;

@Service
public interface UpdateService {
	public Todo findByTodoId(String todoId);

	public void updateOne(Todo todo);

}

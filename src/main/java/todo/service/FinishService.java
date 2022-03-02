package todo.service;

import org.springframework.stereotype.Service;

import todo.model.Todo;

@Service
public interface FinishService {

	public void finishOne(Todo todo);

	public Todo findFinishedDate(String todoId);

	public void unfinishOne(String todoId);
}

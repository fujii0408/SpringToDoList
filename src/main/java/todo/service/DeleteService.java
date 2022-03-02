package todo.service;

import org.springframework.stereotype.Service;

@Service
public interface DeleteService {

	public void deleteOne(String todoId);
}

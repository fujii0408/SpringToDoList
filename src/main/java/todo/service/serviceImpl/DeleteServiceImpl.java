package todo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.repository.TodoMapper;
import todo.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {

	@Autowired
	TodoMapper todoMapper;

	@Override
	public void deleteOne(String todoId) {
		todoMapper.deleteOne(todoId);
	}

}

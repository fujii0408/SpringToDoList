package todo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.model.Todo;
import todo.repository.TodoMapper;
import todo.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private TodoMapper todoMapper;

	@Override
	public List<Todo> searchMany(String searchWord) {
		return todoMapper.searchMany(searchWord);
	}

}

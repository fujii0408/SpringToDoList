package todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import todo.model.Todo;

@Service
public interface SearchService {

	public List<Todo> searchMany(String searchWord);

}

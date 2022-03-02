package todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import todo.model.Todo;

@Mapper
public interface TodoMapper {
	public int insertOne(Todo todo);

	public List<Todo> findTodoList();

	public Todo findByTodoId(String todoId);

	public void updateOne(Todo todo);

	public void deleteOne(String todoId);

	public List<Todo> searchMany(String searchWord);

	public void finishOne(Todo todo);

	public Todo findFinishedDate(String TodoId);

	public void unfinishOne(String todoId);
}

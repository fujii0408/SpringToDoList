package todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import todo.model.User;

@Mapper
public interface UserMapper {
	public User findLoginUser(String userName);

	public int findUser(String userName, String password);

	public List<User> findUsers();

	public int countExistUser(String userId);
}

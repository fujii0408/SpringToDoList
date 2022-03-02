package todo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {
	private String todoId;
	private String userId;
	private String userName;
	private String itemName;
	private Date registrationDate;
	private Date expireDate;
	private Date finishedDate;
}

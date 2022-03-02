package todo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegisterForm {
	private String userName;
	private String userId;

	@Length(max = 100)
	@NotBlank
	private String itemName;

	private String todoId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expireDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date finishedDate;

	private boolean finishedFlag;

	public boolean getFinishedFlag() {
		return finishedFlag;
	}

	public void setFinishedFlag(boolean finishedFlag) {
		this.finishedFlag = finishedFlag;
	}
}

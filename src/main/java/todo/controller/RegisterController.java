package todo.controller;

import java.util.Calendar;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import todo.form.RegisterForm;
import todo.model.Todo;
import todo.model.User;
import todo.service.RegisterService;

@Controller
@Slf4j
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("")
	public String getRegister(Model model, @ModelAttribute RegisterForm form) {

//		登録済ユーザーのリストを取得
		List<User> listUserName = registerService.findUsers();
		model.addAttribute("listUserName", listUserName);

//		タイトル文字をmodelにセット
		model.addAttribute("title", "作業登録");

		return "list/register";
	}

	@PostMapping("")
	public String postTodoList(Model model, @ModelAttribute @Validated RegisterForm form, BindingResult bindingResult) {
		log.info(form.toString());

//		ユーザーが登録されていない場合、エラーを追加する
		if(registerService.countExistUser(form.getUserId()) == 0) {
			FieldError fieldError = new FieldError("RegisterForm", "userId", "存在しないユーザーです");
			bindingResult.addError(fieldError);
		}

//		バリデーションチェック
		if(bindingResult.hasErrors()) {
			return getRegister(model, form);
		}

		Todo todo = modelMapper.map(form, Todo.class);

//		登録日、完了日をセット
		Calendar calendar = Calendar.getInstance();
		todo.setRegistrationDate(calendar.getTime());

		if(form.getFinishedFlag()) {
			todo.setFinishedDate(calendar.getTime());
		}

//		todoの値を挿入
		registerService.register(todo);

		return "redirect:/list";

	}
}
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import todo.form.RegisterForm;
import todo.model.Todo;
import todo.model.User;
import todo.service.RegisterService;
import todo.service.UpdateService;

@Controller
@RequestMapping("/update")
@Slf4j
public class UpdateController {

	@Autowired
	UpdateService updateService;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RegisterService registerService;

	@GetMapping("/{todoId}")
	public String getUpdate(@PathVariable String todoId, Model model) {
		Todo todo = updateService.findByTodoId(todoId);

//		RegisterForm型に変換し、htmlに渡す
		RegisterForm registerForm = modelMapper.map(todo, RegisterForm.class);

//		完了日時が入っていればfinishedFlagを立てる（チェックボックスに初期値を入れるため）
		if(registerForm.getFinishedDate() != null) {
			registerForm.setFinishedFlag(true);
		} else {
			registerForm.setFinishedFlag(false);
		}

		model.addAttribute("registerForm", registerForm);

//		タイトル文字をmodelにセット
		model.addAttribute("title", "作業更新");

		return "list/update";
	}

	@PostMapping("/{todoId}")
	public String postUpdate(Model model, @PathVariable String todoId, @Validated RegisterForm form, BindingResult bindingResult) {

		log.info(form.toString());

//		ユーザーが登録されていない場合、エラーを追加する
		if(registerService.countExistUser(form.getUserId()) == 0) {
			FieldError fieldError = new FieldError("RegisterForm", "userId", "存在しないユーザーです");
			bindingResult.addError(fieldError);
		}

//		バリデーションチェック
		if(bindingResult.hasErrors()) {
			return "list/update";
		}

		Todo todo = modelMapper.map(form, Todo.class);

//		チェックボックスで完了日時を挿入するか判断
		Calendar calendar = Calendar.getInstance();
		if(form.getFinishedFlag()) {
			todo.setFinishedDate(calendar.getTime());
		} else {
			todo.setFinishedDate(null);
		}

//		受け取ったtodoの値でリストを更新
		updateService.updateOne(todo);

//		一覧画面にリダイレクト
		return "redirect:/list";
	}

	@ModelAttribute("listUserName")
	public List<User> createSelectBox() {
//		ユーザーのセレクトボックスの値を取得する
		List<User> listUserName = registerService.findUsers();
		return listUserName;
	}
}

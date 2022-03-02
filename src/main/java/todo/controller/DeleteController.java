package todo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import todo.form.RegisterForm;
import todo.model.Todo;
import todo.service.DeleteService;
import todo.service.TodoListService;
import todo.service.UpdateService;

@Controller
@RequestMapping("/delete")
public class DeleteController {

	@Autowired
	UpdateService updateService;

	@Autowired
	DeleteService deleteService;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	TodoListService todoListService;

	@GetMapping("/{todoId}")
	public String getDeleteOne(@PathVariable String todoId, Model model) {
		Todo todo = updateService.findByTodoId(todoId);

//		RegisterForm型に変換し、htmlに渡す
		RegisterForm registerForm = modelMapper.map(todo, RegisterForm.class);
		model.addAttribute("registerForm", registerForm);

//		タイトル文字をmodelにセット
		model.addAttribute("title", "削除確認");

		return "list/delete";
	}

	@PostMapping("/{todoId}")
	public String postDelete(@PathVariable String todoId, Model model) {

//		is_deleteに1を挿入
		deleteService.deleteOne(todoId);

		return "redirect:/list";
	}
}

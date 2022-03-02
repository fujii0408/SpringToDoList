package todo.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import todo.model.Todo;
import todo.service.FinishService;

@Controller
public class FinishController {

	@Autowired
	FinishService finishService;

	@GetMapping("/finish/{todoId}")
	public String getFinish(@PathVariable String todoId, Todo todo) {

		if(finishService.findFinishedDate(todoId) == null) {
//			todoに受け取ったtodoIdをセット
			todo.setTodoId(todoId);

//			todoに現在の日付をセット
			Calendar calendar = Calendar.getInstance();
			todo.setFinishedDate(calendar.getTime());

//			完了の日付に挿入
			finishService.finishOne(todo);
		} else {
			finishService.unfinishOne(todoId);
		}

		return "redirect:/list";
	}
}

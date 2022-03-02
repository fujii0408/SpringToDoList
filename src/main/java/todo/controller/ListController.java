package todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import todo.form.SearchForm;
import todo.model.Todo;
import todo.model.User;
import todo.service.SearchService;
import todo.service.TodoListService;

@Controller
@RequestMapping("/list")
public class ListController {

	@Autowired
	private TodoListService todoListService;

	@Autowired
	private SearchService searchService;

	@GetMapping("")
	public String getTodoList(@AuthenticationPrincipal User user, Model model, @ModelAttribute SearchForm searchForm) {
//		検索されていない場合
		if(searchForm == null) {
//			登録済todoリストを全て取得しmodelにセット
			List<Todo> todoList = todoListService.findTodoList();
			model.addAttribute("todoList", todoList);

//			タイトル文字をmodelにセット
			model.addAttribute("title", "作業一覧");

//			検索された場合
		} else if(searchForm != null) {
//			todoListに検索で入力された値をセット
			List<Todo> todoList = searchService.searchMany(searchForm.getSearchWord());
			model.addAttribute("todoList", todoList);

//			タイトル文字をmodelにセット
			model.addAttribute("title", "検索一覧");
		}

		return "list/list";
	}

}

//package todo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import todo.form.SearchForm;
//import todo.model.Todo;
//import todo.service.SearchService;
//
//@Controller
//@RequestMapping("/search")
//public class SearchController {
//
//	@Autowired
//	private SearchService searchService;
//
//	@PostMapping("")
//	public String postSearch(SearchForm searchForm, Model model) {
////		todoListに検索で入力された値をセット
//		List<Todo> todoList = searchService.searchMany(searchForm.getSearchWord());
//		model.addAttribute("todoList", todoList);
//
////		タイトル文字をmodelにセット
//		model.addAttribute("title", "検索一覧");
//
//		return "list/list";
//	}
//}

package todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import todo.form.LoginForm;

@Controller
@RequestMapping("/login")
public class LoginController {

//	@Autowired
//	private LoginService loginService;

	@GetMapping("")
	public String getLogin(@ModelAttribute LoginForm form, Model model) {
		model.addAttribute("title", "ログイン");
		return "login/login";
	}

}

package info.chen.awsome.cws.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public void login(ModelAndView maView) {
		maView.setViewName("login");
	}
	
}

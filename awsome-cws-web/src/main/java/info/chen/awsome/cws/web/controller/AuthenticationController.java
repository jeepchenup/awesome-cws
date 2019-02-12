package info.chen.awsome.cws.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import info.chen.awsome.cws.web.controller.api.AuthenticationURIConstants;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value = AuthenticationURIConstants.LOGIN, method = RequestMethod.GET)
	public void login(ModelAndView maView) {
		maView.setViewName("login");
	}
	
	@RequestMapping(value = AuthenticationURIConstants.REGISTER, method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
}

package pe.edu.ucont.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("mensaje","Te saluda Gustavo Coronel");
		return "home";
	}
	
	@GetMapping({"/home2"})
	public ModelAndView home2(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home2");
		mav.addObject("mensaje","Te saluda tu amigo Gustavo Coronel");
		request.setAttribute("frase", "Somos ganadores.");
		return mav;
	}
	
}

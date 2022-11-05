package pe.edu.ucont.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class AppController {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@GetMapping("/saludo")
	public String saludo(String nombre, Model model) {
		model.addAttribute("titulo", "SALUDO");
		model.addAttribute("saludo", "Hola " + nombre);
		return "saludo";
	}

}

package pe.edu.ucont.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.ucont.app.dto.ProductoDto;

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
	
	@GetMapping("/producto")
	public String producto(Model model) {
		ProductoDto dto = new ProductoDto("Laptop", 3500.0, 120);
		model.addAttribute("dto", dto);
		return "producto";
	}

}

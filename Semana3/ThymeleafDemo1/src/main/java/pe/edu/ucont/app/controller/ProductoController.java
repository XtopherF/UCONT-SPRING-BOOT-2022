package pe.edu.ucont.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.ucont.app.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listado(Model model) {
		model.addAttribute("lista", productoService.obtenerProductos());
		return "listado";
	}

}

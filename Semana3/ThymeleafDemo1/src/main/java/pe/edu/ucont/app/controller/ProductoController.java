package pe.edu.ucont.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.ucont.app.dto.ProductoDto;
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
	
	@GetMapping("/consulta")
	public String consulta() {
		return "consulta";
	}
	
	@PostMapping("/consulta")
	public String consulta(String nombre, Model model) {
		ProductoDto dto = productoService.buscar(nombre);
		if(dto==null) {
			model.addAttribute("mensaje", "Producto no existe");
		} else {
			model.addAttribute("dto", dto);
		}
		return "consulta";
	}

}

package pe.edu.ucont.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.ucont.app.entity.Categoria;
import pe.edu.ucont.app.entity.Producto;
import pe.edu.ucont.app.service.CategoriaService;
import pe.edu.ucont.app.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping({ "/", "todos" })
	public String listar(Model model) {
		List<Producto> lista = productoService.listarTodos();
		model.addAttribute("titulo", "LISTA DE PRODUCTOS");
		model.addAttribute("productos", lista);
		return "/productos/listado";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		Producto producto = new Producto();
		List<Categoria> listaCategorias = categoriaService.listarTodos();
		model.addAttribute("titulo", "NUEVO PRODUCTO");
		model.addAttribute("producto", producto);
		model.addAttribute("categorias", listaCategorias);
		return "/productos/frmEditar";
	}
}

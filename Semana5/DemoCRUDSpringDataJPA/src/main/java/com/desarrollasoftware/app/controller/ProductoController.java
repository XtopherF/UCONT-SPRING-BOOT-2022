package com.desarrollasoftware.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desarrollasoftware.app.entity.Categoria;
import com.desarrollasoftware.app.entity.Producto;
import com.desarrollasoftware.app.service.CategoriaService;
import com.desarrollasoftware.app.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping({ "/", "/todos" })
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

	@PostMapping("/grabar")
	public String guardar(@Valid @ModelAttribute Producto producto, BindingResult result, Model model,
			RedirectAttributes atributos) {

		if (result.hasErrors()) {
			System.err.println("Se presentaron errores en el formulario!");
			String titulo = "NUEVO PRODUCTO";
			if (producto.getId() > 0) {
				titulo = "EDITAR PRODUCTO (" + producto.getId() + ")";
			}
			List<Categoria> listaCategorias = categoriaService.listarTodos();
			model.addAttribute("titulo", titulo);
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", listaCategorias);
			return "/productos/frmEditar";
		}

		productoService.grabar(producto);
		System.out.println("Producto grabado con exito!");
		atributos.addFlashAttribute("success", "Producto guardado con exito!");

		return "redirect:/productos/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idProd, Model model, RedirectAttributes atributos) {

		// Id de producto invalido
		if (idProd <= 0) {
			atributos.addFlashAttribute("error", "El id del producto es incorrecto.");
			return "redirect:/productos/todos";
		}

		Producto producto = productoService.buscarPorId(idProd);

		// Id de producto no existe
		if (producto == null) {
			atributos.addFlashAttribute("error", "El id del producto no existe.");
			return "redirect:/productos/todos";
		}

		List<Categoria> listaCategorias = categoriaService.listarTodos();
		model.addAttribute("titulo", "EDITAR PRODUCTO (" + idProd + ")");
		model.addAttribute("producto", producto);
		model.addAttribute("categorias", listaCategorias);
		return "/productos/frmEditar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idProd, RedirectAttributes atributos) {

		// Id de producto invalido
		if (idProd <= 0) {
			atributos.addFlashAttribute("error", "El ID del producto es incorrecto.");
			return "redirect:/productos/todos";
		}
		
		Producto producto = productoService.buscarPorId(idProd);
		
		// Id de producto no existe
		if (producto == null) {
			atributos.addFlashAttribute("error", "El ID del producto no existe.");
			return "redirect:/productos/todos";
		}

		productoService.eliminar(idProd);
		System.out.println("Producto eliminado con exito!");
		atributos.addFlashAttribute("warning", "Producto eliminado con éxito.");
		
		return "redirect:/productos/";

	}

}

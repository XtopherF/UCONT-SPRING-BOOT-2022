package pe.edu.ucont.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.ucont.app.model.Empleado;
import pe.edu.ucont.app.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping({ "/", "/todos" })
	@ResponseBody
	public List<Empleado> listar() {
		List<Empleado> lista = empleadoService.listarTodos();
		return lista;
	}

	@GetMapping("/leer/{id}")
	@ResponseBody
	public Empleado editar(@PathVariable("id") Long id) {
		Empleado empleado = empleadoService.buscarPorId(id);
		return empleado;
	}

	@GetMapping("/eliminar/{id}")
	@ResponseBody
	public Empleado eliminar(@PathVariable("id") Long id) {
		Empleado empleado = empleadoService.buscarPorId(id);
		empleadoService.eliminar(id);
		return empleado;
	}

	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@PostMapping("/grabar")
	@ResponseBody
	public Empleado guardar(@ModelAttribute Empleado empleado) {
		System.err.println(empleado);
		Empleado bean = empleadoService.grabar(empleado);
		System.err.println(empleado);
		return bean;
	}
}

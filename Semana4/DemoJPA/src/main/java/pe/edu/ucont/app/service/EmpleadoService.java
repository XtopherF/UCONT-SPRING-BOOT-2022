package pe.edu.ucont.app.service;

import java.util.List;
import java.util.Map;

import pe.edu.ucont.app.model.Empleado;

public interface EmpleadoService {

	List<Empleado> listarTodos();

	Empleado buscarPorId(Long id);

	Empleado grabar(Empleado empleado);

	void eliminar(Long id);
	
	List<Map<String,Object>> leerEmpleados();

	List<Empleado> buscarPorNombre(String nombre);
}

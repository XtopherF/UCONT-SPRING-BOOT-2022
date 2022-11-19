package pe.edu.ucont.app.service;

import java.util.List;

import pe.edu.ucont.app.model.Empleado;

public interface EmpleadoService {

	List<Empleado> listarTodos();

	Empleado buscarPorId(Long id);

	Empleado grabar(Empleado empleado);

	void eliminar(Long id);

}

package pe.edu.ucont.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pe.edu.ucont.app.model.Empleado;
import pe.edu.ucont.app.repository.EmpleadoRepository;
import pe.edu.ucont.app.service.EmpleadoService;

@Service
public class EmpleadoServImpl implements EmpleadoService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarTodos() {
		return (List<Empleado>) empleadoRepository.findAll();
	}

	@Override
	public Empleado buscarPorId(Long id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public Empleado grabar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void eliminar(Long id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	public List<Map<String, Object>> leerEmpleados() {
		String query = "select IDEMP, NOMBRE, APELLIDO EMAIL, TELEFONO from empleado";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public List<Empleado> buscarPorNombre(String nombre) {
		return empleadoRepository.findByNombreContainingIgnoreCase(nombre);
	}
	
	
}

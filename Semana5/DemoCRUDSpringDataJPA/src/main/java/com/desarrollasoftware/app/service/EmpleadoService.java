package com.desarrollasoftware.app.service;

import java.util.List;

import com.desarrollasoftware.app.entity.Empleado;

public interface EmpleadoService {

	List<Empleado> listarTodos();
	
	Empleado buscarPorId(Long id);
	
	Empleado grabar(Empleado empleado);
	
	void eliminar(Long id);
	
	List<Empleado> buscarPorNombreApellido(String nombre, String apellido);
	
	List<Empleado> buscarPorNombre(String nombre);
	
	Empleado buscarPorEmail(String email);
	
}

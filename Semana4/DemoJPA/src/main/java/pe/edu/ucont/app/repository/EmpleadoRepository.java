package pe.edu.ucont.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.ucont.app.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

	List<Empleado> findByNombreAndApellido(String nombre, String apellido);

	List<Empleado> findByNombreLike(String nombre);

	List<Empleado> findByNombreContaining(String nombre);

	List<Empleado> findByNombreContainingIgnoreCase(String nombre);

	List<Empleado> findByNombreLikeIgnoreCase(String nombre);

}

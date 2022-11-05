package pe.edu.ucont.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.ucont.app.dto.ProductoDto;

@Service
public class ProductoService {

	
	public List<ProductoDto> obtenerProductos(){
		return Data.lista;
	}

	public ProductoDto buscar(String nombre) {
		ProductoDto dto = null;
		for(ProductoDto bean: Data.lista) {
			if(bean.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
				dto = bean;
				break;
			}
		}
		return dto;
	}
	
	
}

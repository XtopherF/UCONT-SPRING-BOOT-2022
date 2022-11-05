package pe.edu.ucont.app.service;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ucont.app.dto.ProductoDto;

class Data {
	
	static final List<ProductoDto> lista;
	
	static {
		lista = new ArrayList<>();
		lista.add(new ProductoDto("LAPTOP", 4500.0, 80));
		lista.add(new ProductoDto("MONITOR", 600.0, 120));
		lista.add(new ProductoDto("IMPRESORA", 760.0, 70));
		lista.add(new ProductoDto("CELULAR", 690.0, 230));
		lista.add(new ProductoDto("DISCO DURO", 240.0, 50));
	}

}

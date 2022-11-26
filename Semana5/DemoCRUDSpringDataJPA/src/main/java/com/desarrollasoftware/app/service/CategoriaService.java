package com.desarrollasoftware.app.service;

import java.util.List;
import java.util.Map;

import com.desarrollasoftware.app.entity.Categoria;

public interface CategoriaService {

	List<Categoria> listarTodos();
	
	List<Map<String,?>> listarCategorias();

}

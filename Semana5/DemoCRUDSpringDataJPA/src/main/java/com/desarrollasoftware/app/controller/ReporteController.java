package com.desarrollasoftware.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desarrollasoftware.app.service.CategoriaService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	 private ResourceLoader resourceLoader;
	
	@GetMapping("/categorias")
	public void categorias(HttpServletResponse response) {
		
		try {
			List<Map<String,?>> lista = categoriaService.listarCategorias();
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			System.out.println("Filas: " + lista.size());
			System.out.println("Filas: " + data.getRecordCount());
				
			String reporte = "classpath:reports/Categorias.jrxml";
			String path = resourceLoader.getResource(reporte).getURI().getPath();
			System.out.println("Gustavo: " + path);
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, null, data);
			if( bytes == null ) {
				throw new Exception("No hay nada");
			}
			
			//response.setContentType("application/pdf");
			
			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"categorias.pdf\""));
			
			response.setContentLength(bytes.length);
			ServletOutputStream out = response.getOutputStream();
			out.write(bytes, 0, bytes.length);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
}

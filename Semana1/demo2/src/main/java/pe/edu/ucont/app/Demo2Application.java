package pe.edu.ucont.app;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.ucont.app.service.MateService;
import pe.edu.ucont.app.service.VentaService;

@SpringBootApplication
@RestController
public class Demo2Application {

	@Autowired
	private MateService mateService;
	
	@Inject
	private VentaService ventaService;

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	@GetMapping("/venta")
	public String venta(int precio, int cant) {
		int importe = ventaService.calcVenta(precio, cant);
		String rpta = "Valor venta: " + importe;
		return rpta;
	}

	@GetMapping("/sumar")
	public String sumar(int n1, int n2) {
		int suma = mateService.sumar(n1, n2);
		String rpta = "Suma: " + n1 + " + " + n2 + " = " + suma;
		return rpta;
	}

	@GetMapping("/saludo")
	public String saludo(String nombre) {
		return "Hola " + nombre;
	}

}

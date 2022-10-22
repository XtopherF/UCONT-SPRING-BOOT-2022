package pe.edu.ucont.app.service;

import javax.inject.Named;

@Named
public class VentaService {

	public int calcVenta(int precio, int cant) {
		return (precio * cant);
	}
	
}

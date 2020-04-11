package ar.edu.utn.dds.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperacionEgreso {
	
	List<Producto> productos;
	
	public OperacionEgreso() {
		productos = new ArrayList();
	}
	
	public void agregarProducto(Producto prod) {
		productos.add(prod);
	}
	
	public void quitarProducto(Producto prod) {
		productos.remove(prod);
	}
	
	public double calcularValor() {
		return productos.stream().mapToDouble(item->item.getValor()).sum();
		
		
	}

}

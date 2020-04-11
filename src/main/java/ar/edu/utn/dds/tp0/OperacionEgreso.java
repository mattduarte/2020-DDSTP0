package ar.edu.utn.dds.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.utn.dds.tp0.exceptions.NoHayItemsException;
import ar.edu.utn.dds.tp0.exceptions.NoSonTodosArticulosException;

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
	
	public double calcularValor() throws NoHayItemsException {
		if(productos.stream().count() == 0) {
			throw new NoHayItemsException();
		}
		return productos.stream().mapToDouble(item->item.getValor()).sum();
		
		
	}
	
	
	public void generarRemito() throws NoSonTodosArticulosException {
		boolean sonTodosArticulos = productos.stream().allMatch(item->item.isArticulo());
		if(!sonTodosArticulos) {
			throw new NoSonTodosArticulosException();
		}
		
		//generarRemito
				
	}

}

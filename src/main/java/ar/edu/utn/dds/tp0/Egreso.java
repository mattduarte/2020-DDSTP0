package ar.edu.utn.dds.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.utn.dds.tp0.exceptions.NoHayItemsException;
import ar.edu.utn.dds.tp0.exceptions.NoSonTodosArticulosException;
import ar.edu.utn.dds.tp0.exceptions.OperacionCerradaException;

public class Egreso {
	
	List<Item> productos;
	private boolean operacionCerrada;
	private boolean tieneRemito;
	
	public Egreso() {
		productos = new ArrayList();
	}
	
	
	
	public boolean isTieneRemito() {
		return this.tieneRemito;
	}
	
	public int cantidadItems() {
		
		return	productos.size();
		}



	public void agregarProducto(Item prod) throws OperacionCerradaException {
		if(operacionCerrada) {
			throw new OperacionCerradaException();
		}
		productos.add(prod);
	}
	
	
	public void modificarPrecioArticulo(Item item, double precio) throws OperacionCerradaException {
		if(operacionCerrada) {
			throw new OperacionCerradaException();
		}
		
		item.modificarPrecio(precio);
	}
	
	
	public void quitarProducto(Item prod) {
		productos.remove(prod);
	}
	
	public void cerrarOperacion() {
		this.operacionCerrada = true;
	}
	
	public double calcularValor() throws NoHayItemsException {
		if(productos.stream().count() == 0) {
			throw new NoHayItemsException();
		}
		return productos.stream().mapToDouble(item->item.getPrecio()).sum();
		
		
	}
	
	
	public void generarRemito() throws NoSonTodosArticulosException {
		boolean sonTodosArticulos = productos.stream().allMatch(item->item.generaCertificado());
		if(!sonTodosArticulos) {
			throw new NoSonTodosArticulosException();
		}
		
		this.tieneRemito = true;
				
	}



	

	
	
}

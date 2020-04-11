package ar.edu.utn.dds.tp0;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.utn.dds.tp0.exceptions.NoHayItemsException;
import ar.edu.utn.dds.tp0.exceptions.NoSonTodosArticulosException;

public class EgresoTest {
	
	
	OperacionEgreso egreso = new OperacionEgreso();
	Articulo lampara = new Articulo(700);
	Articulo cargadorPortatil = new Articulo(1700);
	Servicio internet = new Servicio();

	@Test
	public void testAgrego2articulosYMeDevuelveLaSumaCorrecta() throws NoHayItemsException {
		egreso.agregarProducto(lampara);
		egreso.agregarProducto(cargadorPortatil);
		
		Assert.assertEquals(2400,egreso.calcularValor(),0);
		
	}
	
	@Test(expected = NoHayItemsException.class)
	public void testConsultoElValorTotalCuandoNoHayItems() throws NoHayItemsException {
		egreso.calcularValor();
		
	}
	
	@Test(expected = NoSonTodosArticulosException.class)
	public void testNoGeneraRemitoPorqueNoSonTodosArticulos() throws NoSonTodosArticulosException {
		egreso.agregarProducto(lampara);
		egreso.agregarProducto(internet);
		egreso.generarRemito();
	}
	
	
}

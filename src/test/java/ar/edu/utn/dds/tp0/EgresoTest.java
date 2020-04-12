package ar.edu.utn.dds.tp0;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.utn.dds.tp0.exceptions.NoHayItemsException;
import ar.edu.utn.dds.tp0.exceptions.NoSonTodosArticulosException;
import ar.edu.utn.dds.tp0.exceptions.OperacionCerradaException;

public class EgresoTest {
	
	
	Egreso egreso = new Egreso();
	Articulo lampara = new Articulo(700);
	Articulo cargadorPortatil = new Articulo(1700);
	Servicio internet = new Servicio();

	@Test
	public void testAgrego2articulosYMeDevuelveLaSumaCorrecta() throws NoHayItemsException, OperacionCerradaException {
		egreso.agregarProducto(lampara);
		egreso.agregarProducto(cargadorPortatil);
		
		Assert.assertEquals(2400,egreso.calcularValor(),0);
		
	}
	
	@Test(expected = NoHayItemsException.class)
	public void testConsultoElValorTotalCuandoNoHayItems() throws NoHayItemsException {
		egreso.calcularValor();
		
	}
	
	
	@Test (expected = OperacionCerradaException.class)
	public void testNoSePuedeAgregarItemsPorqueLaOperacionEstaCerrada() throws OperacionCerradaException {
		egreso.cerrarOperacion();
		egreso.agregarProducto(lampara);
	}
	
	
	@Test
	public void testSiLaOperacionNoEstaCerradaPuedoAgregarProductos() throws OperacionCerradaException {
		egreso.agregarProducto(cargadorPortatil);
		egreso.agregarProducto(internet);
		assertEquals(2, egreso.cantidadItems());
	}
	
	
	@Test(expected = OperacionCerradaException.class)
	public void testNoSePuedeModificarPrecioPorqueLaOperacionEstaCerrada() throws OperacionCerradaException {
		egreso.agregarProducto(internet);
		egreso.cerrarOperacion();
		egreso.modificarPrecioArticulo(internet, 2500);
	}
	
	@Test
	public void testSiLaOperacionNoEstaCerradaPuedeModificarElPrecioDeUnItem() throws OperacionCerradaException, NoHayItemsException {
		egreso.agregarProducto(lampara);
		egreso.modificarPrecioArticulo(lampara, 500);
		assertEquals(500,egreso.calcularValor(),0);
	}
	
	
	@Test(expected = NoSonTodosArticulosException.class)
	public void testNoGeneraRemitoPorqueNoSonTodosArticulos() throws NoSonTodosArticulosException, OperacionCerradaException {
		egreso.agregarProducto(lampara);
		egreso.agregarProducto(internet);
		egreso.generarRemito();
	}
	
	@Test
	public void testGeneraRemitoSiSonTodosArticulos() throws OperacionCerradaException, NoSonTodosArticulosException {
		egreso.agregarProducto(lampara);
		egreso.agregarProducto(cargadorPortatil);
		egreso.generarRemito();
		assertTrue(egreso.isTieneRemito());
		
	}
	
	
}

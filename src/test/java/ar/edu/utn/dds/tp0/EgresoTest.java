package ar.edu.utn.dds.tp0;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EgresoTest {
	
	
	OperacionEgreso egreso = new OperacionEgreso();

	@Test
	public void testAgrego2articulosYMeDevuelveLaSumaCorrecta() {
		Articulo lampara = new Articulo(700);
		Articulo cargadorPortatil = new Articulo(1700);
		egreso.agregarProducto(lampara);
		egreso.agregarProducto(cargadorPortatil);
		
		
		Assert.assertEquals(2400,egreso.calcularValor(),0);
		
	}
	
	
}

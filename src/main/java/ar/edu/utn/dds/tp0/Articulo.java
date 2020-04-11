package ar.edu.utn.dds.tp0;

public class Articulo extends Producto {


	public Articulo(double valor) {
		this.setValor(valor);
	}

	public boolean isArticulo() {
		return true;
	}

	public boolean isServicio() {
		return false;
	}

	
	
	
}

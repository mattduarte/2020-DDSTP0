package ar.edu.utn.dds.tp0;

public abstract class Producto {

	protected String descripcion;
	protected double valor;
	
 public double getValor() {
		
		return this.valor;
	}

 public void setValor(double valor) {
	 this.valor = valor;
 }
	public abstract boolean isArticulo();
	public abstract boolean isServicio();
}

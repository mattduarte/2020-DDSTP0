package ar.edu.utn.dds.tp0;

public abstract class Item {

	protected String descripcion;
	protected double precio;
	
 public double getPrecio() {
		
		return this.precio;
	}

 public void setPrecio(double valor) {
	 this.precio = valor;
 }
	public abstract boolean generaCertificado();
	
	public void modificarPrecio(double precio) {
		this.setPrecio(precio);
	}
	
}

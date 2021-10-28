package model;

import java.util.ArrayList;

public class DescuentoPorcentaje extends Promocion {
	public int descuento;

//	public DescuentoPorcentaje(String nombrePropuesta, String tipo, int cantAtracciones, double descuento,
//			List<Propuestas> promo) {
//		super(nombrePropuesta, tipo, cantAtracciones);
//		this.descuento = descuento;
//		this.promo = (ArrayList<Propuestas>) promo;
//		DescuentoPorcentaje.cantAtracciones = cantAtracciones;
//	}
	
	public DescuentoPorcentaje(String nombrePropuesta, int descuento) {
		super(nombrePropuesta, descuento);
		this.descuento = descuento;
		//this.promo = (ArrayList<Propuestas>) promo;
	}
	
	public void setLista(ArrayList<Propuestas> a){
		this.promo = a;
	}
	
	public int getDescuento() {
		return descuento;
	}

	@Override
	public int calcularCosto() {
		return (int) (super.calcularCosto() * this.getDescuento());
	}

	@Override
	public double calcularTiempo() {
		return super.calcularTiempo();
	}

	@Override
	public int calcularCupo() {
		return super.calcularCupo();
	}

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + getCosto() + "; Tiempo: " + getTiempo()
				+ "; Cupo: " + getCupo() + "; Cantidad de atracciones: " + cantAtracciones + "; Descuento: "
				+ descuento + " %" + "\n";
	}

	public int getCosto() {
		return this.costo;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public int getCupo() {
		return this.cupo;
	}

	public String getTipo() {
		return this.tipo;
	}
	
	public int setCosto(int costo) {
		return this.costo = costo;	
	}
	public double setTiempo(double tiempo) {
		return this.tiempo = tiempo;
	}
	public int setCupo(int cupo) {
		return this.cupo = cupo;
	}
	public int setDescuento(int descuento) {
		return this.descuento = descuento;
	}
	public int getCantAtracciones() {
		return this.cantAtracciones;
	}
	public int setCantAtracciones(int cant) {
		return this.cantAtracciones = cant;
	}
	public String setTipo(String tipo) {
		return this.tipo = tipo; 
	}
}
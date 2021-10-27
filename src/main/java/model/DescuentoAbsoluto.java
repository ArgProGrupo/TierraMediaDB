package model;

import java.util.ArrayList;

public class DescuentoAbsoluto extends Promocion {
	private int descuento;

//	public DescuentoAbsoluto(String nombrePropuesta, String tipo, int cantAtracciones, int descuento,
//			List<Propuestas> promo) {
//		super(nombrePropuesta, tipo, cantAtracciones);
//		this.descuento = descuento;
//		this.promo = (ArrayList<Propuestas>) promo;
//	}
	
//	public DescuentoAbsoluto(String nombrePropuesta, int costo, double tiempo, int cupo, String tipo) {
//		super(nombrePropuesta, tipo, cantAtracciones);
//		this.costo = costo;
//		this.tiempo = tiempo;
//		this.cupo = cupo;
//		this.promo = (ArrayList<Propuestas>) promo;
//	}
	
//	public DescuentoAbsoluto(String nombrePropuesta , String tipo, int cantAtracciones) {
//		super(nombrePropuesta, tipo, cantAtracciones);
//		this.promo = (ArrayList<Propuestas>) promo;
//	}
	public DescuentoAbsoluto(String nombrePropuesta , int descuento) {
		super(nombrePropuesta, descuento);
		this.promo = (ArrayList<Propuestas>) promo;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public int calcularCosto() {
		return (super.calcularCosto() - this.descuento);
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
				+ "; Cupo: " + getCupo() + "; Cantidad de atracciones: " + getCantAtracciones() + "; Descuento: "
				+ getDescuento() + " Monedas de oro";
	}

//	public int getCosto() {
//		return calcularCosto();
//	}
//
//	public double getTiempo() {
//		return calcularTiempo();
//	}
//
//	public int getCupo() {
//		return calcularCupo();
//	}
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
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
	
	public DescuentoPorcentaje(String nombrePropuesta, String tipo, int descuento) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.descuento = descuento;
		//this.promo = (ArrayList<Propuestas>) promo;
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
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() + "; Tiempo: " + calcularTiempo()
				+ "; Cupo: " + calcularCupo() + "; Cantidad de atracciones: " + cantAtracciones + "; Descuento: "
				+ (100 - (descuento * 100)) + "%";
	}

	public int getCosto() {
		return calcularCosto();
	}

	public double getTiempo() {
		return calcularTiempo();
	}

	public int getCupo() {
		return calcularCupo();
	}

	public String getTipo() {
		return this.tipo;
	}
}

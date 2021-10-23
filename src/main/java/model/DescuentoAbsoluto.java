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
	
	public DescuentoAbsoluto(String nombrePropuesta, String tipo, int descuento) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.descuento = descuento;
		this.promo = (ArrayList<Propuestas>) promo;
	}

	public int getDescuento() {
		return descuento;
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
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() + "; Tiempo: " + calcularTiempo()
				+ "; Cupo: " + calcularCupo() + "; Cantidad de atracciones: " + cantAtracciones + "; Descuento: "
				+ getDescuento() + " Monedas de oro";
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
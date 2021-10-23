package model;

import java.util.ArrayList;
import java.util.List;

//import administradorDeArchivos.ListaPropuestas;

public class DescuentoTresPorDos extends Promocion {
	public Propuestas atraccionGratis;
	public int idAtraccionGratis;
//	public int idAtraccion1;
//	public int idAtraccion2;

//	public DescuentoTresPorDos(String nombrePropuesta, String tipo, int cantAtracciones,
//			Propuestas atraccionGratis, List<Propuestas> promo) {
//		super(nombrePropuesta, tipo, cantAtracciones);
//		this.promo = (ArrayList<Propuestas>) promo;
//		this.atraccionGratis = atraccionGratis;
//	}
	
	public DescuentoTresPorDos(String nombrePropuesta, String tipo, int idAtraccionGratisz) {
		super(nombrePropuesta, tipo, cantAtracciones);
//		idAtraccion1 = this.idAtraccion1;
//		idAtraccion2 = this.idAtraccion2;
		this.idAtraccionGratis = idAtraccionGratis;
		this.promo = (ArrayList<Propuestas>) promo;
	}

	public Propuestas getAtraccionGratis() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();
		//ListaPropuestas.leerAtraccion();
		for (Propuestas a : propuestas) {
			if (a.getNombre().equals(atraccionGratis.getNombre())) {

				System.out.println(promo);

			}
		}
		return atraccionGratis;
	}
	
	public int getIdAtraccionGratis() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();
		//ListaPropuestas.leerAtraccion();
		for (Propuestas a : propuestas) {
			if (a.getNombre().equals(atraccionGratis.getNombre())) {

				System.out.println(promo);

			}
		}
		return atraccionGratis.idAtraccion;
	}

	@Override
	public int calcularCosto() {
		return (super.calcularCosto() - atraccionGratis.getCosto());
	}

	@Override
	public int calcularCupo() {
		if (super.calcularCupo() >= atraccionGratis.getCupo())
			return atraccionGratis.getCupo();
		else
			return super.calcularCupo();
	}

	@Override
	public double calcularTiempo() {
		return super.calcularTiempo();
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

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() +
				"; Tiempo: " + calcularTiempo() + "; Cupo: " + calcularCupo() + 
				"; Cantidad de atracciones: " +	promo.size() + 
				"; Atraccion de regalo: " + atraccionGratis.getNombre();
	}
}

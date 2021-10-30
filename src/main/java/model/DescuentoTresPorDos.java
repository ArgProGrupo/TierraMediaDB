package model;

import java.util.ArrayList;
import java.util.List;

public class DescuentoTresPorDos extends Promocion {
	public Propuestas atraccionGratis;
	public int idAtraccionGratis;

	public DescuentoTresPorDos(String nombrePropuesta, int idAtraccionGratis) {
		super(nombrePropuesta);
		this.idAtraccionGratis = idAtraccionGratis;
		this.esPromo = true;
	}

	public Propuestas getAtraccionGratis() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();
		// ListaPropuestas.leerAtraccion();
		for (Propuestas a : propuestas) {
			if (a.getNombre().equals(atraccionGratis.getNombre())) {

				System.out.println(promo);

			}
		}
		return atraccionGratis;
	}

	public int getIdAtraccionGratis() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();
		for (Propuestas a : propuestas) {
			if (a.getNombre().equals(atraccionGratis.getNombre())) {

				System.out.println(promo);

			}
		}
		return atraccionGratis.idAtraccion;
	}

	public void setLista(ArrayList<Propuestas> a) {
		this.promo = a;
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

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + getCosto() + "; Tiempo: " + getTiempo() + "; Cupo: "
				+ calcularCupo() + "; Cantidad de atracciones: " + promo.size() + "; Atraccion de regalo: "
				+ atraccionGratis.getNombre() + "\n";
	}

	public int setCosto(int costo) {
		return this.costo = (costo - atraccionGratis.getCosto());
	}

	public double setTiempo(double tiempo) {
		return this.tiempo = tiempo;
	}

	public int setCupo(int cupo) {
		return this.cupo = cupo;
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

	public int setIdAtracccionGratis(int idAtraccionGratis) {
		return this.idAtraccionGratis = idAtraccionGratis;
	}

	public Propuestas setAtraccionGratis(Atraccion atraccionGratis) {
		return this.atraccionGratis = atraccionGratis;
	}

	public int setIdPromo(int id) {
		return this.idPromocion = id;
	}
}

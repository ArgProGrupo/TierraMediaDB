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
	
//	public DescuentoTresPorDos(String nombrePropuesta, String tipo, int cantAtracciones) {
//		super(nombrePropuesta, tipo, cantAtracciones);
////		idAtraccion1 = this.idAtraccion1;
////		idAtraccion2 = this.idAtraccion2;
////		this.idAtraccionGratis = idAtraccionGratis;
//		this.promo = (ArrayList<Propuestas>) promo;
//	}

	public DescuentoTresPorDos(String nombrePropuesta,  int idAtraccionGratis) {
		super(nombrePropuesta);
		this.idAtraccionGratis = idAtraccionGratis;
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
	
	public void setLista(ArrayList<Propuestas> a){
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

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + getCosto() +
				"; Tiempo: " + getTiempo() + "; Cupo: " + getCupo() + 
				"; Cantidad de atracciones: " +	getCantAtracciones() + 
				"; Atraccion de regalo: " + atraccionGratis.getNombre() + "\n";
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
}

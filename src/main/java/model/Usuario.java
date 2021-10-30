package model;

import java.util.*;

public class Usuario {

	public int idUsuario;
	public String nombre;
	public String atraccionFavorita;
	public int presupuesto;
	public double tiempoDisponible;
	public ArrayList<Propuestas> itinerarioUsuario;

	public Usuario(int idUsuario, String nombre, String atraccionFavorita, int presupuesto, 
			double tiempoDisponible) {
		
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		
		this.itinerarioUsuario = new ArrayList<Propuestas>();
	}
	
	public Usuario(String nombre, String atraccionFavorita, int presupuesto, double tiempoDisponible) {
		this.nombre = nombre;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		
		this.itinerarioUsuario = new ArrayList<Propuestas>();
	}
	
	public Usuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public int setIdUsuario(int id) {
		return this.idUsuario = id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public double getTiempo() {
		return this.tiempoDisponible;
	}

	public String getTipoAtraccionFavorita() {
		return this.atraccionFavorita;
	}

	public String getItinerarioString() {
		String itinerario = "";
		if (itinerario == "") {
			for (Propuestas p : itinerarioUsuario)
				itinerario += p + "\n";
		} else
			itinerario = "";
		return itinerario;

	}

	@Override
	public String toString() {
		return "id_usuario: " + idUsuario + " | Nombre: " + nombre +
			   " | Atraccion Favorita: " + atraccionFavorita + " | Presupuesto: " + presupuesto +
			   " | Tiempo Disponible: " + tiempoDisponible;
	}

	public boolean puedeComprar(Propuestas propuesta) {
		if (this.getPresupuesto() >= propuesta.getCosto() && 
			this.getTiempo() >= propuesta.getTiempo() &&
			propuesta.getCupo() > 0) {
			if (propuesta.esPromo) {
				for (Propuestas p : itinerarioUsuario) {
					if (propuesta.esOContiene(p))
						return false;
				}
			} else {
				if (itinerarioUsuario.contains(propuesta)) {
					return false;
				} else {
					for (Propuestas p : itinerarioUsuario) {
						if (p.esOContiene(propuesta))
							return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	public void comprarPropuesta(Propuestas propuesta) {
		if (puedeComprar(propuesta)) {
			this.presupuesto -= propuesta.getCosto();
			this.tiempoDisponible -= propuesta.getTiempo();
			itinerarioUsuario.add(propuesta);

			System.out.println("Te quedan " + this.presupuesto + " monedas y " + this.tiempoDisponible + " horas");
		}
	}

	public boolean tieneTiempoYDinero() {
		if (this.getPresupuesto() > 0 && this.getTiempo() > 0)
			return true;
		else
			return false;
	}
}

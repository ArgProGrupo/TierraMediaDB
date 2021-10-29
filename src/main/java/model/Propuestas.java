package model;

import java.util.Objects;

public abstract class Propuestas {
	protected int idPromocion;
	protected int idAtraccion;
	protected String nombrePropuesta;
	protected int costo;
	protected double tiempo;
	protected int cupo;
	protected String tipo;
	protected int cantAtracciones;
	protected boolean esPromo;

	public Propuestas(String nombrePropuesta, int costo, double tiempo, int cupo, String tipo) {
		this.nombrePropuesta = nombrePropuesta;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}
	
	public Propuestas(int id, String nombrePropuesta, int costo, double tiempo, int cupo, String tipo) {
		this.idAtraccion = id;
		this.nombrePropuesta = nombrePropuesta;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public Propuestas(String nombrePropuesta, String tipo, int cantAtracciones) {
		this.nombrePropuesta = nombrePropuesta;
		this.tipo = tipo;
		this.cantAtracciones = cantAtracciones;
	}
	
	public Propuestas(String nombrePropuesta) {
		this.nombrePropuesta = nombrePropuesta;
	}

	public Propuestas() {
		
	}
	
	public int getIdAtraccion() {
		return this.idAtraccion;
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

	public String getNombre() {
		return this.nombrePropuesta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, nombrePropuesta, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propuestas other = (Propuestas) obj;
		return costo == other.costo && Objects.equals(nombrePropuesta, other.nombrePropuesta)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo) && tipo == other.tipo;
	}

	public int restarCupo() {
		if (this.cupo > 0) {
			this.cupo = getCupo();
			this.cupo--;
			System.out.println("El cupo disponible para esta atracci�n es de " + cupo + "\n ------------------------");
		}
		return this.cupo;

	}
	
	public boolean getEsPromo() {
		return this.esPromo;
	}

	protected abstract boolean esOContiene(Propuestas propuesta);

	public int getIdPromocion() {
		return this.idPromocion;
	}

}
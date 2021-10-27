package model;

public class Atraccion extends Propuestas {
	private int idAtraccion;
	
	public Atraccion(int idAtraccion, String nombrePropuesta, int costo, double tiempo, int cupo, String tipo) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.idAtraccion = idAtraccion;
		this.esPromo = false;
	}

	public Atraccion(String nombrePropuesta, int costo, double tiempo, int cupo, String tipo) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.esPromo = false;
	}
	
	public Atraccion(int idAtraccion) {
		super();
		this.idAtraccion = idAtraccion;
	}
	
	
	public int getIdAtraccion() {
		return this.idAtraccion;
	}

	@Override
	public String toString() {
		return "Id: " + idAtraccion + " | Nombre: " + nombrePropuesta + " | Costo: " 
				+ costo + " | Tiempo: " + tiempo + " | Cupo: "
				+ getCupo() + " | Tipo De Atraccion: " + tipo + "\n";
	}

	@Override
	protected boolean esOContiene(Propuestas propuesta) {
		return (this.equals(propuesta));
	}
}

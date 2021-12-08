package model;

import java.util.*;

public class Promocion extends Propuestas {

	protected int idPromocion;
	protected int cantAtracciones;
	protected ArrayList<Propuestas> promo;
	protected int descuento;
	private String tipoPromo;
	private Propuestas atraccionGratis;

//	public Promocion(int idPromocion, String nombrePropuesta, String tipo, int cantAtracciones) {
//		super(nombrePropuesta, tipo, cantAtracciones);
//		this.idPromocion = idPromocion;
//		this.promo = new ArrayList<Propuestas>();
//	}
//
//	public Promocion(String nombrePropuesta, String tipo, int cantAtracciones) {
//		super(nombrePropuesta, tipo, cantAtracciones);
////		this.promo = (ArrayList<Propuestas>) promo;
//		this.promo = new ArrayList<Propuestas>();
//	}
//
//	public Promocion(String nombrePropuesta, int descuento) {
//		super(nombrePropuesta);
//		this.descuento = descuento;
//		this.promo = new ArrayList<Propuestas>();
//	}
	public Promocion(int idPromocion, String nombrePropuesta, int descuento, String tipoPromo, String tipo) {
		super(nombrePropuesta);
		this.idPromocion = idPromocion;
		this.descuento = descuento;
		this.tipoPromo = tipoPromo;
		this.promo = new ArrayList<Propuestas>();
		this.tipo = tipo;
		this.esPromo = true;
	}

	public Promocion(String nombrePropuesta) {
		super(nombrePropuesta);
		this.promo = new ArrayList<Propuestas>();
	}

	public Promocion(int idPromocion) {
		super();
		this.idPromocion = idPromocion;
	}

	public int getIdPromocion() {
		return this.idPromocion;
	}

	public int calcularCosto() {
		int costopromo = 0;
		this.costo = 0;
		for (Propuestas p : promo) {
			costopromo += p.getCosto();
		}
		if (tipoPromo.equals("abs")) {
			costopromo -= this.descuento;
		}
		if (tipoPromo.equals("porcentaje")) {
			costopromo -= (costopromo * descuento / 100);
		}
		if(tipoPromo.equals("axb")){
		if (promo.size() > 0)
			costopromo -= (promo.get((promo.size() - 1)).getCosto());
		else {
			costopromo = 0;
		}
		}
		return this.costo = costopromo;

	}

	public double calcularTiempo() {
		double tiempototal = 0;
		for (Propuestas p : promo) {
			tiempototal += p.getTiempo();
		}
		return this.tiempo = tiempototal;
	}

	public int calcularCupo() {
		int cupoMaximo = 100;
		this.cupo = cupoMaximo;
		
		for (Propuestas p : promo) {
			if (cupoMaximo > p.getCupo())
				cupoMaximo = p.getCupo();
		}
		return this.cupo = cupoMaximo;
	}

	@Override
	public int restarCupo() {
		for (Propuestas p : promo)
			if (p.cupo > 0) {
				p.cupo = p.getCupo();
				p.cupo--;
				System.out.println("El cupo disponible para " + p.getNombre() + " es de " + p.cupo + ".");
			}
		System.out.println("------------------------");
		return calcularCupo();
	}

	@Override
	protected boolean esOContiene(Propuestas propuesta) {
		if (propuesta.esPromo) {
			for (Propuestas a : this.promo) {
				if (propuesta.esOContiene(a))
					return true;

			}
		} else
			return (this.promo.contains(propuesta));
		return false;
	}

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + getCosto() + "; Tiempo: " + calcularTiempo()
				+ "; Cupo: " + getCupo() + "; Cantidad de atracciones: " + promo.size() + "\n";
	}

	public ArrayList<Propuestas> getPromoList() {
		return promo;
	}

	public void setLista(ArrayList<Propuestas> a) {
		this.promo = a;
		this.tipo = a.get(0).getTipo();
		calcularCosto();
		calcularCupo();
		calcularTiempo();
	}
	
	public String setTipo() {
		return this.tipo = this.promo.get(0).getTipo();
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public int getDescuento() {
		return descuento;
	}

	public String getTipoPromo() {
		return tipoPromo;
	}
	public boolean getEsPromo() {
		return this.esPromo;
	}
}
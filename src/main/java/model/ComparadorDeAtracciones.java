package model;

import java.util.Comparator;

public class ComparadorDeAtracciones implements Comparator<Propuestas> {
	private String favorito;

	public ComparadorDeAtracciones(String favorito) {
		this.favorito = favorito;
	}

	public int compare(Propuestas at1, Propuestas at2) {
		if (this.favorito.compareTo(at1.getTipo()) == 0 && this.favorito.compareTo(at2.getTipo()) != 0)
			return -1;
		else if (this.favorito.compareTo(at1.getTipo()) != 0 && this.favorito.compareTo(at2.getTipo()) == 0)
			return 1;
		else {
			if (at1.esPromo == true && at2.esPromo != true)
				return -1;
			else if (at1.esPromo != true && at2.esPromo == true)
				return 1;
			else if (at1.getCosto() > at2.getCosto())
				return -1;
			else if (at1.getCosto() < at2.getCosto())
				return 1;
			else {
				if (at1.getTiempo() > at2.getTiempo())
					return -1;
				else if (at1.getTiempo() < at2.getTiempo())
					return 1;
				else
					return 0;
			}
		}
	}
}

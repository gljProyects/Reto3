package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

;

public class Pelicula implements Serializable {

	private static final long serialVersionUID = 4825478076256101165L;
	
	private int cod_pelicula;
	private int duracion;
	private String genero;

	ArrayList<Emision> emisiones = null;

	@Override
	public String toString() {
		return "Pelicula [cod_pelicula=" + cod_pelicula + ", duracion=" + duracion + ", genero=" + genero
				+ ", emisiones=" + emisiones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_pelicula, duracion, emisiones, genero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return cod_pelicula == other.cod_pelicula && duracion == other.duracion
				&& Objects.equals(emisiones, other.emisiones) && Objects.equals(genero, other.genero);
	}

	public int getCod_pelicula() {
		return cod_pelicula;
	}

	public void setCod_pelicula(int cod_pelicula) {
		this.cod_pelicula = cod_pelicula;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ArrayList<Emision> getEmisiones() {
		return emisiones;
	}

	public void setEmisiones(ArrayList<Emision> emisiones) {
		this.emisiones = emisiones;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}

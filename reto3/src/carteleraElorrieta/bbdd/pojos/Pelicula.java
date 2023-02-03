package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.Objects;

public class Pelicula implements Serializable{

	
	private static final long serialVersionUID = 5310038255982230545L;
	private int cod_pelicula;
	private String genero;
	private int duracion;

	@Override
	public String toString() {
		return "Pelicula [cod_pelicula=" + cod_pelicula + ", genero=" + genero + ", duracion=" + duracion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_pelicula, duracion, genero);
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
		return cod_pelicula == other.cod_pelicula && duracion == other.duracion && Objects.equals(genero, other.genero);
	}

	public int getCod_pelicula() {
		return cod_pelicula;
	}

	public void setCod_pelicula(int cod_pelicula) {
		this.cod_pelicula = cod_pelicula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}

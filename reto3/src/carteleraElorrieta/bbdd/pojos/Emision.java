package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Emision implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4841339245413385962L;

	// clave primaria
	private int cod_emision;

	private Date fecha;
	private LocalTime horario;
	private int precio;

	private ArrayList<Entrada> entradas = null;
	private Sala sala = null;
	private Pelicula pelicula = null;

	@Override
	public String toString() {
		return "Emision [cod_emision=" + cod_emision + ", fecha=" + fecha + ", horario=" + horario + ", precio="
				+ precio + ", entradas=" + entradas + ", sala=" + sala + ", pelicula=" + pelicula + "]";
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(cod_emision, entradas, fecha, horario, pelicula, precio, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emision other = (Emision) obj;
		return cod_emision == other.cod_emision && Objects.equals(entradas, other.entradas)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(horario, other.horario)
				&& Objects.equals(pelicula, other.pelicula) && precio == other.precio
				&& Objects.equals(sala, other.sala);
	}

	public int getCod_emision() {
		return cod_emision;
	}

	public void setCod_emision(int cod_emision) {
		this.cod_emision = cod_emision;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(ArrayList<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

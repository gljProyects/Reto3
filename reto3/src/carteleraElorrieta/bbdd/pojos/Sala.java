package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Sala implements Serializable {

	private static final long serialVersionUID = 5066114702351219436L;

	//clave primaria
	private int cod_sala;
	
	//atributos
	private String nombre;
	
	//relacion N:1 con cine
	private Cine cine = null;
	
	//relacion 1:N con emisiones
	private ArrayList<Emision> emisiones = null;

	

	public int getCod_sala() {
		return cod_sala;
	}

	public void setCod_sala(int cod_sala) {
		this.cod_sala = cod_sala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
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
	
	@Override
	public String toString() {
		return "Sala [cod_sala=" + cod_sala + ", nombre=" + nombre + ", cine=" + cine + ", emisiones=" + emisiones
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cine, cod_sala, emisiones, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(cine, other.cine) && cod_sala == other.cod_sala
				&& Objects.equals(emisiones, other.emisiones) && Objects.equals(nombre, other.nombre);
	}

}

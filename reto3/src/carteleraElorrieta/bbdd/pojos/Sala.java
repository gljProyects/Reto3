package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Sala implements Serializable {

	private static final long serialVersionUID = 8181135287334784618L;
	private int cod_sala;
	private String nombre;

	Cine cine = null;
	ArrayList<Emision> emisiones = null;

	@Override
	public String toString() {
		return "Sala [cod_sala=" + cod_sala + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_sala, nombre);
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
		return cod_sala == other.cod_sala && Objects.equals(nombre, other.nombre);
	}

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

}

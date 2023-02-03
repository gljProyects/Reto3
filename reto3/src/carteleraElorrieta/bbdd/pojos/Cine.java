package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cine implements Serializable {

	private static final long serialVersionUID = -834238569626668040L;
	private int cod_sala;
	private int nombre_sala;
	private String relacion;
	private int cod_cine;
	ArrayList<Sala> salas = null;

	@Override
	public String toString() {
		return "Cine [cod_sala=" + cod_sala + ", nombre_sala=" + nombre_sala + ", relacion=" + relacion + ", cod_cine="
				+ cod_cine + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_cine, cod_sala, nombre_sala, relacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return cod_cine == other.cod_cine && cod_sala == other.cod_sala && nombre_sala == other.nombre_sala
				&& Objects.equals(relacion, other.relacion);
	}

	public int getCod_sala() {
		return cod_sala;
	}

	public void setCod_sala(int cod_sala) {
		this.cod_sala = cod_sala;
	}

	public int getNombre_sala() {
		return nombre_sala;
	}

	public void setNombre_sala(int nombre_sala) {
		this.nombre_sala = nombre_sala;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public int getCod_cine() {
		return cod_cine;
	}

	public void setCod_cine(int cod_cine) {
		this.cod_cine = cod_cine;
	}

}

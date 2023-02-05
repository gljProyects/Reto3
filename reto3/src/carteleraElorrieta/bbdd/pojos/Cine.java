package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cine implements Serializable {

	private static final long serialVersionUID = -3879462207701133525L;

	private int cod_cine;
	private String direccion;
	private int num_sala;
	private String nombre;
	ArrayList<Sala> salas = null;

	@Override
	public String toString() {
		return "Cine [cod_cine=" + cod_cine + ", direccion=" + direccion + ", num_sala=" + num_sala + ", nombre="
				+ nombre + ", salas=" + salas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_cine, direccion, nombre, num_sala, salas);
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
		return cod_cine == other.cod_cine && Objects.equals(direccion, other.direccion)
				&& Objects.equals(nombre, other.nombre) && num_sala == other.num_sala
				&& Objects.equals(salas, other.salas);
	}

	public int getCod_cine() {
		return cod_cine;
	}

	public void setCod_cine(int cod_cine) {
		this.cod_cine = cod_cine;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNum_sala() {
		return num_sala;
	}

	public void setNum_sala(int num_sala) {
		this.num_sala = num_sala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

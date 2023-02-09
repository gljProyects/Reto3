package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Cine implements Serializable {

	private static final long serialVersionUID = -3879462207701133525L;

	// clave primaria
	private int cod_cine;

	// atributos
	private String direccion;
	private String nombre;
	
	// relacion 1:N con sala
	ArrayList<Sala> salas = null;

	

	@Override
	public String toString() {
		return "Cine [cod_cine=" + cod_cine + ", direccion=" + direccion + ", nombre=" + nombre + ", salas=" + salas
				+ "]";
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cod_cine, direccion, nombre, salas);
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
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(salas, other.salas);
	}

}

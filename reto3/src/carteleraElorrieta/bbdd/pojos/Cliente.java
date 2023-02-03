package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -751544450533683460L;
	// DNI, Contraseña, Nombre, Apellidos
	private String dni = null;
	private String contraseña = null;
	private String nombre = null;
	private String apellidos = null;

	
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", contraseña=" + contraseña + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ "]";
	}

	ArrayList<Entrada> entrada = null;
	
	public int hashCode() {
		return Objects.hash(apellidos, contraseña, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(contraseña, other.contraseña)
				&& Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}
	
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	


}

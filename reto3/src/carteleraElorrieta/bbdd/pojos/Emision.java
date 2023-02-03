package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Emision implements Serializable{

	
	private static final long serialVersionUID = 1020962104556644391L;
	private int cod_emision;
	private Date fecha;
	private Date horario;
	private int precio;

	Sala sala = null;
	Pelicula pelicula=null;
	ArrayList<Entrada> entradas = null;
	
	@Override
	public String toString() {
		return "Emision [cod_emision=" + cod_emision + ", fecha=" + fecha + ", horario=" + horario + ", precio="
				+ precio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_emision, fecha, horario, precio);
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
		return cod_emision == other.cod_emision && Objects.equals(fecha, other.fecha)
				&& Objects.equals(horario, other.horario) && precio == other.precio;
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

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}

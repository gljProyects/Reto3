package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Entrada implements Serializable {

	private static final long serialVersionUID = 8554642783300054225L;
	private int cod_entrada;
	private Date fecha_compra;

	@Override
	public String toString() {
		return "Entrada [cod_entrada=" + cod_entrada + ", fecha_compra=" + fecha_compra + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_entrada, fecha_compra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return cod_entrada == other.cod_entrada && Objects.equals(fecha_compra, other.fecha_compra);
	}

	public int getCod_entrada() {
		return cod_entrada;
	}

	public void setCod_entrada(int cod_entrada) {
		this.cod_entrada = cod_entrada;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

}

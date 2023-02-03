package carteleraElorrieta.bbdd.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Entrada implements Serializable {

	
	private static final long serialVersionUID = 4196253156002190181L;
	private int cod_entrada;
	private Date fecha_compra;
	Cliente cliente = null;
	Emision emision = null;

	@Override
	public String toString() {
		return "Entrada [cod_entrada=" + cod_entrada + ", fecha_compra=" + fecha_compra + ", cliente=" + cliente
				+ ", emision=" + emision + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, cod_entrada, emision, fecha_compra);
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
		return Objects.equals(cliente, other.cliente) && cod_entrada == other.cod_entrada
				&& Objects.equals(emision, other.emision) && Objects.equals(fecha_compra, other.fecha_compra);
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Emision getEmision() {
		return emision;
	}

	public void setEmision(Emision emision) {
		this.emision = emision;
	}

}

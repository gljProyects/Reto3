package testCarteleraElorrieta.testPojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Entrada;
import carteleraElorrieta.bbdd.pojos.Pelicula;
import carteleraElorrieta.bbdd.pojos.Sala;

class TestEmision {

	@Test
	public void testGettersAndSettersCodEmision() {
		Emision emision = new Emision();
		int cod_emision = 1;
		emision.setCod_emision(cod_emision);
		assertEquals(cod_emision, emision.getCod_emision());
	}

	@Test
	public void testGettersAndSettersFecha() {
		Emision emision = new Emision();
		Date fecha = null;
		emision.setFecha(fecha);
		assertEquals(fecha, emision.getFecha());
	}

	@Test
	public void testGettersAndSettersHorario() {
		Emision emision = new Emision();
		LocalTime horario = null;
		emision.setHorario(horario);
		assertEquals(horario, emision.getHorario());
	}

	@Test
	public void testGettersAndSettersPrecio() {
		Emision emision = new Emision();
		int precio = 1;
		emision.setPrecio(precio);
		assertEquals(precio, emision.getPrecio());
	}

	@Test
	public void testGettersAndSettersEntradas() {
		Emision emision = new Emision();
		ArrayList<Entrada> entradas = null;
		emision.setEntradas(entradas);
		assertNull(emision.getEntradas());
	}

	@Test
	public void testGettersAndSettersSala() {
		Emision emision = new Emision();
		Sala sala = null;
		emision.setSala(sala);
		assertNull(emision.getSala());
	}

	@Test
	public void testGettersAndSettersPelicula() {
		Emision emision = new Emision();
		Pelicula pelicula = null;
		emision.setPelicula(pelicula);
		assertNull(emision.getPelicula());
	}

	@Test
	public void testToString() {
		Emision emision = new Emision();

		String expected = "Emision [cod_emision=" + 0 + ", fecha=" + null + ", horario=" + null + ", precio=" + 0
				+ ", entradas=" + null + ", sala=" + null + ", pelicula=" + null + "]";
		emision.toString();
		assertEquals(expected, emision.toString());
	}

	@Test
	public void testEqualsTrue() {
		Emision emision = new Emision();
		emision.setCod_emision(1);

		Emision emision2 = new Emision();
		emision2.setCod_emision(1);
		emision.equals(emision2);
		assertTrue(emision.equals(emision2));

	}

	@Test
	public void testEqualsFalse() {
		Emision emision = new Emision();
		emision.setCod_emision(1);

		Emision emision2 = new Emision();
		emision2.setCod_emision(2);
		emision.equals(emision2);
		assertFalse(emision.equals(emision2));

	}

}

package testCarteleraElorrieta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import carteleraElorrieta.bbdd.pojos.Cine;
import carteleraElorrieta.bbdd.pojos.Sala;

public class testCine {

	@Test
	public void testGettersAndSettersCodCine() {
		Cine cine = new Cine();
		int cod_cine = 1;
		cine.setCod_cine(cod_cine);
		assertEquals(cod_cine, cine.getCod_cine());
	}

	@Test
	public void testGettersAndSettersDireccion() {
		Cine cine = new Cine();
		String direccion = "Portugalete";
		cine.setDireccion(direccion);
		assertEquals(direccion, cine.getDireccion());
	}

	@Test
	public void testGettersAndSettersNumSala() {
		Cine cine = new Cine();
		int num_sala = 1;
		cine.setNum_sala(num_sala);
		assertEquals(num_sala, cine.getNum_sala());
	}

	@Test
	public void testGettersAndSettersNombre() {
		Cine cine = new Cine();
		String nombre = "Gonzalo";
		cine.setNombre(nombre);
		assertEquals(nombre, cine.getNombre());
	}

	@Test
	public void testGettersAndSettersSalas() {
		Cine cine = new Cine();
		ArrayList<Sala> salas = null;
		cine.setSalas(salas);
		assertNull(cine.getSalas());
	}

	@Test
	public void testToString() {
		Cine cine = new Cine();

		String expected = "Cine [cod_cine=" + 0 + ", direccion=" + null + ", num_sala=" + 0 + ", nombre=" + null
				+ ", salas=" + null + "]";
		cine.toString();
		assertEquals(expected, cine.toString());
	}

	@Test
	public void testEqualsTrue() {
		Cine cine = new Cine();
		cine.setCod_cine(1);

		Cine cine2 = new Cine();
		cine2.setCod_cine(1);
		cine.equals(cine2);
		assertTrue(cine.equals(cine2));

	}

	@Test
	public void testEqualsFalse() {
		Cine cine = new Cine();
		cine.setCod_cine(1);

		Cine cine2 = new Cine();
		cine2.setCod_cine(2);
		cine.equals(cine2);
		assertFalse(cine.equals(cine2));

	}
}

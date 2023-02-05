package testCarteleraElorrieta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import carteleraElorrieta.bbdd.pojos.Cine;

public class testCine {

	@Test
	public void testGettersAndSetters() {
		Cine cine = new Cine();
		int cod_cine = 1;
		cine.setCod_cine(cod_cine);
		assertEquals(cod_cine, cine.getCod_cine());
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

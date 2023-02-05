package testCarteleraElorrieta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.pojos.Sala;

class testSala {
	@Test
	public void testGettersAndSetters() {
		Sala sala = new Sala();
		int cod_sala = 1;
		sala.setCod_sala(cod_sala);
		assertEquals(cod_sala, sala.getCod_sala());
	}

	@Test
	public void testToString() {
		Sala sala = new Sala();

		String expected = "Sala [cod_sala=" + 0 + ", nombre=" + null + ", cine=" + null + ", emisiones=" + null
				+ "]";
		sala.toString();
		assertEquals(expected, sala.toString());
	}

	@Test
	public void testEqualsTrue() {
		Sala sala = new Sala();
		sala.setCod_sala(1);

		Sala sala2 = new Sala();
		sala2.setCod_sala(1);
		sala.equals(sala2);
		assertTrue(sala.equals(sala2));

	}

	@Test
	public void testEqualsFalse() {
		Sala sala = new Sala();
		sala.setCod_sala(1);

		Sala sala2 = new Sala();
		sala2.setCod_sala(2);
		sala.equals(sala2);
		assertFalse(sala.equals(sala2));

	}

	
}

package testCarteleraElorrieta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.pojos.Emision;

class testEmision {

	@Test
	public void testGettersAndSetters() {
		Emision emision = new Emision();
		int cod_emision = 1;
		emision.setCod_emision(cod_emision);
		assertEquals(cod_emision, emision.getCod_emision());
	}

	@Test
	public void testToString() {
		Emision emision = new Emision();

		String expected = "Emision [cod_emision=" + 0 + ", fecha=" + null + ", horario=" + null + ", precio="
				+ 0 + ", entradas=" + null + ", sala=" + null + ", pelicula=" + null + "]";
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

package testCarteleraElorrieta;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.pojos.Entrada;

class testEntrada {

	@Test
	public void testGettersAndSetters() {
		Entrada entrada = new Entrada();
		int cod_entrada = 1;
		entrada.setCod_entrada(cod_entrada);
		assertEquals(cod_entrada, entrada.getCod_entrada());
	}

	@Test
	public void testToString() {
		Entrada entrada = new Entrada();

		String expected = "Entrada [cod_entrada=" + 0 + ", fecha_compra=" + null + ", cliente=" + null
				+ ", emision=" + null + "]";
		entrada.toString();
		assertEquals(expected, entrada.toString());
	}

	@Test
	public void testEqualsTrue() {
		Entrada entrada = new Entrada();
		entrada.setCod_entrada(1);

		Entrada entrada2 = new Entrada();
		entrada2.setCod_entrada(1);
		entrada.equals(entrada2);
		assertTrue(entrada.equals(entrada2));

	}

	@Test
	public void testEqualsFalse() {
		Entrada entrada = new Entrada();
		entrada.setCod_entrada(1);

		Entrada entrada2 = new Entrada();
		entrada2.setCod_entrada(2);
		entrada.equals(entrada2);
		assertFalse(entrada.equals(entrada2));

	}

}

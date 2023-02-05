package testCarteleraElorrieta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.pojos.Cliente;

class testCliente {

	@Test
	public void testGettersAndSetters() {
		Cliente cliente = new Cliente();
		String nombre= "Gonzalo";
		cliente.setNombre("Gonzalo");
		assertEquals(nombre, cliente.getNombre());
	}

	@Test
	public void testToString() {
		Cliente cliente = new Cliente();

		String expected = "Cliente [dni=" + null + ", nombre=" + null + ", apellidos=" + null + ", contraseña=" + null
				+ ", entradas=" + null + "]";
		cliente.toString();
		assertEquals(expected, cliente.toString());
	}

	@Test
	public void testEqualsTrue() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Gonzalo");

		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Gonzalo");
		cliente.equals(cliente2);
		assertTrue(cliente.equals(cliente2));

	}

	@Test
	public void testEqualsFalse() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Gonzalo");

		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Lander");
		cliente.equals(cliente2);
		assertFalse(cliente.equals(cliente2));

	}

}

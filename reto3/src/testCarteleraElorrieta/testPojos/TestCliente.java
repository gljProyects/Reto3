package testCarteleraElorrieta.testPojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.pojos.Cliente;
import carteleraElorrieta.bbdd.pojos.Entrada;

class TestCliente {

	@Test
	public void testGettersAndSettersNombre() {
		Cliente cliente = new Cliente();
		String nombre = "Gonzalo";
		cliente.setNombre(nombre);
		assertEquals(nombre, cliente.getNombre());
	}

	@Test
	public void testGettersAndSettersDni() {
		Cliente cliente = new Cliente();
		String dni = "20982629M";
		cliente.setDni(dni);
		assertEquals(dni, cliente.getDni());
	}

	@Test
	public void testGettersAndSettersApellidos() {
		Cliente cliente = new Cliente();
		String apellidos = "Barrasa, Almeida";
		cliente.setApellidos(apellidos);
		assertEquals(apellidos, cliente.getApellidos());
	}

	@Test
	public void testGettersAndSettersContraseña() {
		Cliente cliente = new Cliente();
		String contraseña = "1234ABCD";
		cliente.setContraseña(contraseña);
		assertEquals(contraseña, cliente.getContraseña());
	}

	@Test
	public void testGettersAndSettersSexo() {
		Cliente cliente = new Cliente();
		String sexo = "Mujer";
		cliente.setContraseña(sexo);
		assertEquals(sexo, cliente.getContraseña());
	}

	@Test
	public void testGettersAndSettersEntradas() {
		Cliente cliente = new Cliente();
		ArrayList<Entrada> entradas = null;
		cliente.setEntradas(entradas);
		assertNull(cliente.getEntradas());
	}

	@Test
	public void testToString() {
		Cliente cliente = new Cliente();

		String expected = "Cliente [dni=" + null + ", nombre=" + null + ", apellidos=" + null + ", contraseña=" + null
				+ ", sexo=" + null + ", entradas=" + null + "]";
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

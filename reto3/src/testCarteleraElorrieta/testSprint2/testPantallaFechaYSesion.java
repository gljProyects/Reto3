package testCarteleraElorrieta.testSprint2;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;
import carteleraElorrieta.bbdd.pojos.Emision;

class testPantallaFechaYSesion {

	@Test
	void testFechasDeUnaPeliculaNotNull() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorPeliculas("Buscando a Nemo", "Bilbao");
		assertNotNull(emisiones);

	}

	@Test
	public void testFechasDeUnaPeliculaSize() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorPeliculas("Buscando a Nemo", "Bilbao");
		int tamañoEmisiones = 0;
		tamañoEmisiones = emisiones.size();

		int expected = 1;
		assertEquals(expected, tamañoEmisiones);
	}

	@Test
	public void testFechasDeUnaPeliculaValue() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorPeliculas("Buscando a Nemo", "Bilbao");
		String expected = "2023-02-13";
		String fecha = null;
		fecha = emisiones.get(0).getFecha().toString();
		assertEquals(expected, fecha);
	}

	@Test
	public void testSesionesDeUnaFechaYPeliculaNotNull() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		assertNotNull(emisiones);
	}

	@Test
	public void testSesionesDeUnaFechaYPeliculaSize() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		int tamañoEmisiones = 0;
		tamañoEmisiones = emisiones.size();
		int expected = 1;
		assertEquals(expected, tamañoEmisiones);
	}

	@Test
	public void testSesionesDeUnaFechaYPeliculaValue() {
		GestorBBDD gestorBBDD = new GestorBBDD();

		ArrayList<Emision> emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");

		String sesion = emisiones.get(0).getHorario().toString() + " " + emisiones.get(0).getPrecio() + " "
				+ emisiones.get(0).getSala().getNombre();

		String expected = "18:30 5 Sala 4";
		assertEquals(expected, sesion);
	}

	@Test
	public void testPrecioDeUnaPeliculaNotNull() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		assertNotNull(emisiones);
	}

	@Test
	public void testPrecioDeUnaPeliculaSize() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		int tamañoEmisiones = 0;
		tamañoEmisiones = emisiones.size();
		int expected = 1;
		assertEquals(expected, tamañoEmisiones);
	}

	@Test
	public void testPrecioDeUnaPeliculaValue() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		int expected = 5;
		int precio = 0;
		precio = emisiones.get(0).getPrecio();
		assertEquals(expected, precio);
	}

	@Test
	public void testSalasDeUnaPeliculaNotNull() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		assertNotNull(emisiones);
	}

	@Test
	public void testSalasDeUnaPeliculaSize() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		int tamañoEmisiones = 0;
		tamañoEmisiones = emisiones.size();
		int expected = 1;
		assertEquals(expected, tamañoEmisiones);
	}

	@Test
	public void testSalasDeUnaPeliculaValue() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Emision> emisiones = null;
		emisiones = gestorBBDD.sacarEmisionesPorFecha("2023-02-13", "Buscando a Nemo", "Bilbao");
		String expected = "Sala 4";
		String salas = "";
		salas = emisiones.get(0).getSala().getNombre();

		assertEquals(expected, salas);
	}

}

package testCarteleraElorrieta.testSprint2;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;
import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Pelicula;

class testPantallaPeliculas {

	@Test
	public void testPeliculasDeUnCineNotNull() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Pelicula> peliculas = null;
		peliculas = gestorBBDD.sacarPeliculasPorCine("Bilbao");
		assertNotNull(peliculas);

	}

	@Test
	public void testPeliculasDeUnCineSize() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Pelicula> peliculas = null;
		peliculas = gestorBBDD.sacarPeliculasPorCine("Bilbao");
		int tamañoPeliculas = 0;
		tamañoPeliculas = peliculas.size();
		int expected = 30;
		assertEquals(expected, tamañoPeliculas);
	}

	@Test
	public void testPeliculasDeUnCineValue() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Pelicula> peliculas = null;
		peliculas = gestorBBDD.sacarPeliculasPorCine("Bilbao");

		String expected = "Ciudad de dios";
		String nombrePelicula = null;
		nombrePelicula = peliculas.get(0).getNombre();

		assertEquals(expected, nombrePelicula);
	}

	@Test
	public void testOrdenarPeliculas() {
		GestorBBDD gestorBBDD = new GestorBBDD();

		ArrayList<Emision> emisiones = gestorBBDD.sacarEmisionesPorPeliculas("Los puentes de Madison", "Pamplona");

		// comprobar orden de peliculas por horas
		for (int i = 0; i < emisiones.size() - 1; i++) {
			System.out.println(emisiones);
			Date fechaPrimeraPelicula = emisiones.get(i).getFecha();
			System.out.println(fechaPrimeraPelicula);
			Date fechaSiguientePelicula = emisiones.get(i+1).getFecha();
			System.out.println(fechaSiguientePelicula);
			assertTrue(fechaPrimeraPelicula.before(fechaSiguientePelicula));

		}
	}
}

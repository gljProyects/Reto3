package testCarteleraElorrieta.testSprint2;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
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
		String expected = "Sleepers";
		String nombrePelicula = null;
		nombrePelicula = peliculas.get(0).getNombre();

		assertEquals(expected, nombrePelicula);
	}

	@Test
	public void testOrdenarPeliculas() {
		GestorBBDD gestorBBDD = new GestorBBDD();

		ArrayList<Emision> emisiones = null;

		// comprobar orden de peliculas por horas
		for (int i = 0; i < emisiones.size(); i++) {
			emisiones = gestorBBDD.sacarEmisionesPorPeliculas("Los puentes de Madison", "Pamplona");
			System.out.println(emisiones);
			Date fechaUltimaPelicula = null;
			Date fechaPrimeraPelicula = emisiones.get(0).getFecha();
			assertEquals(fechaPrimeraPelicula, fechaUltimaPelicula);
			fechaUltimaPelicula = fechaPrimeraPelicula;
		}
	}
}

package testCarteleraElorrieta.testSprint2;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;

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
		String expected = "Taxi Driver";
		String nombrePelicula = null;
		nombrePelicula = peliculas.get(0).getNombre();
		assertEquals(expected, nombrePelicula);
	}
	
}

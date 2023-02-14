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
		String expected = "Sleepers";
		String nombrePelicula = null;
		nombrePelicula = peliculas.get(0).getNombre();
		System.out.println(nombrePelicula);
		assertEquals(expected, nombrePelicula);
	}

	@Test
	public void testOrdenarPeliculas() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Pelicula> peliculas = null;
		peliculas = gestorBBDD.sacarPeliculasPorCine("Bilbao");

		String primeraPelicula = peliculas.get(0).getNombre().toString();
		String ultimaPelicula = peliculas.get(peliculas.size() - 1).getNombre().toString();

		if (primeraPelicula.equals("Sleepers") && (ultimaPelicula.equals("Jungla de cristal"))) {
			ArrayList<Emision> emisiones = null;
			ArrayList<Emision> emisiones1 = null;
			emisiones = gestorBBDD.sacarEmisionesPorPeliculas("Sleepers", "Bilbao");
			emisiones1 = gestorBBDD.sacarEmisionesPorPeliculas("Jungla De Cristal", "Bilbao");
			Date fechaPrimeraPelicula = emisiones.get(0).getFecha();
			Date fechaUltimaPelicula = emisiones1.get(0).getFecha();
			
			assertTrue(fechaPrimeraPelicula.before(fechaUltimaPelicula));

		}
		
		

	}
}

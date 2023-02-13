package testCarteleraElorrieta.testPojos;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Pelicula;

class TestPelicula {

	@Test
	public void testGettersAndSettersCodPelicula() {
		Pelicula pelicula = new Pelicula();
		int cod_pelicula = 1;
		pelicula.setCod_pelicula(cod_pelicula);
		assertEquals(cod_pelicula, pelicula.getCod_pelicula());
	}

	@Test
	public void testGettersAndSettersDuracion() {
		Pelicula pelicula = new Pelicula();
		int duracion = 1;
		pelicula.setDuracion(duracion);
		assertEquals(duracion, pelicula.getDuracion());
	}

	@Test
	public void testGettersAndSetterGenero() {
		Pelicula pelicula = new Pelicula();
		String genero = "Drama";
		pelicula.setGenero(genero);
		assertEquals(genero, pelicula.getGenero());
	}

	@Test
	public void testGettersAndSetterNomrbe() {
		Pelicula pelicula = new Pelicula();
		String nombre = "Pepito";
		pelicula.setGenero(nombre);
		assertEquals(nombre, pelicula.getGenero());
	}

	@Test
	public void testGettersAndSettersEntradas() {
		Pelicula pelicula = new Pelicula();
		ArrayList<Emision> emisiones = null;
		pelicula.setEmisiones(emisiones);
		assertNull(pelicula.getEmisiones());
	}

	@Test
	public void testToString() {
		Pelicula pelicula = new Pelicula();

		String expected = "Pelicula [cod_pelicula=" + 0 + ", duracion=" + 0 + ", genero=" + null + ", nombre=" + null
				+ ", emisiones=" + null + "]";
		pelicula.toString();
		assertEquals(expected, pelicula.toString());
	}

	@Test
	public void testEqualsTrue() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCod_pelicula(1);

		Pelicula pelicula2 = new Pelicula();
		pelicula2.setCod_pelicula(1);
		pelicula.equals(pelicula2);
		assertTrue(pelicula.equals(pelicula2));

	}

	@Test
	public void testEqualsFalse() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCod_pelicula(1);

		Pelicula pelicula2 = new Pelicula();
		pelicula2.setCod_pelicula(2);
		pelicula.equals(pelicula2);
		assertFalse(pelicula.equals(pelicula2));

	}

}

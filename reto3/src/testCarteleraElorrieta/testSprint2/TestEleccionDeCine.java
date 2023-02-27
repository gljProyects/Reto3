package testCarteleraElorrieta.testSprint2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;
import carteleraElorrieta.bbdd.pojos.Cine;

public class TestEleccionDeCine {

	@Test
	public void testCinesDisponiblesNotNull() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Cine> cines = null;
		cines = gestorBBDD.sacarTodosLosCiness();
		assertNotNull(cines);

	}

	@Test
	public void testCinesDisponiblesSize() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Cine> cines = null;
		cines = gestorBBDD.sacarTodosLosCiness();
		int tamañoCines = 0;
		tamañoCines = cines.size();
		int expected = 3;
		assertEquals(expected, tamañoCines);
	}

	@Test
	public void testCinesDisponiblesValue() {
		GestorBBDD gestorBBDD = new GestorBBDD();
		ArrayList<Cine> cines = null;
		cines = gestorBBDD.sacarTodosLosCiness();
		String expected = "Bilbao";
		String nombreCine = null;
		nombreCine = cines.get(0).getNombre();
		
		assertEquals(expected, nombreCine);
	}

}

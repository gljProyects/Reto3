package testCarteleraElorrieta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import carteleraElorrieta.bbdd.pojos.Cine;

public class testCine {

	@Test
	public void testGettersAndSetters() {
		Cine cine = new Cine();
		int cod_cine = 1;
		cine.setCod_cine(cod_cine);
		assertEquals(cod_cine, cine.getCod_cine());
	}

	@Test
	public void testToString() {
		Cine cine = new Cine();
		
		cine.setCod_cine(0);
		cine.setDireccion(null);
		cine.setNombre(null);
		cine.setNum_sala(0);
		cine.setSalas(null);

		String expected = "Cine [cod_cine=" + 0 + ", direccion=" + null + ", num_sala=" + 0
				+ ", nombre=" + null + ", salas=" + null + "]";
		cine.toString();
		assertEquals(expected, cine.toString());
	}

}

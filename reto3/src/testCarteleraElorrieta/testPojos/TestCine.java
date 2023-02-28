package testCarteleraElorrieta.testPojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;
import carteleraElorrieta.bbdd.pojos.Cine;
import carteleraElorrieta.bbdd.pojos.Cliente;
import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Entrada;
import carteleraElorrieta.bbdd.pojos.Sala;

public class TestCine {

	@Test
	public void testGettersAndSettersCodCine() {
		Cine cine = new Cine();
		int cod_cine = 1;
		cine.setCod_cine(cod_cine);
		assertEquals(cod_cine, cine.getCod_cine());
	}

	@Test
	public void testGettersAndSettersDireccion() {
		Cine cine = new Cine();
		String direccion = "Portugalete";
		cine.setDireccion(direccion);
		assertEquals(direccion, cine.getDireccion());
	}

	@Test
	public void testGettersAndSettersNombre() {
		Cine cine = new Cine();
		String nombre = "Gonzalo";
		cine.setNombre(nombre);
		assertEquals(nombre, cine.getNombre());
	}

	@Test
	public void testComprobarEntradaNull() {
		Entrada entradaParaRegistrar = new Entrada();
		Cliente cliente = new Cliente();
		Emision emision = new Emision();
		GestorBBDD gestor = new GestorBBDD();
		cliente.setDni("30972629L");
		emision.setCod_emision(1);
		entradaParaRegistrar.setEmision(emision);
		entradaParaRegistrar.setCliente(cliente);
		entradaParaRegistrar.setCod_entrada(60);

		boolean comproparEntrada = gestor.comprobarEntrada(entradaParaRegistrar);

		assertFalse(comproparEntrada);
	}

	@Test
	public void testComprobarEntradaNotNull() {
		Entrada entradaParaRegistrar = new Entrada();
		Cliente cliente = new Cliente();
		Emision emision = new Emision();
		GestorBBDD gestor = new GestorBBDD();
		cliente.setDni("30972629L");
		emision.setCod_emision(1);
		entradaParaRegistrar.setEmision(emision);
		entradaParaRegistrar.setCliente(cliente);
		entradaParaRegistrar.setCod_entrada(60);
		gestor.insertarEntradaClienteTest(entradaParaRegistrar);
		boolean comproparEntrada = gestor.comprobarEntrada(entradaParaRegistrar);
		assertTrue(comproparEntrada);
	}
	
	@Test
	public void testComprobarFichero() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_d HH-mm-ss");
		String date = dateFormat.format(new Date());
		final String NOMBRE_FICHERO = "Ticket " + date + ".txt";
		final String RUTA_FICHERO = "C:\\Users\\in1dw3\\git\\Reto3\\reto3\\src\\carteleraElorrieta\\tickets\\";
		File fichero = new File(RUTA_FICHERO + NOMBRE_FICHERO);

		try {
			
			if (fichero.createNewFile())
				System.out.println("El fichero se ha creado correctamente");
			else
				System.out.println("No ha podido ser creado el fichero");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

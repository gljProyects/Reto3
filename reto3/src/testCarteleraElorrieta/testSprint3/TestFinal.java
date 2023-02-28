package testCarteleraElorrieta.testSprint3;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import carteleraElorrieta.bbdd.gestor.GestorBBDD;
import carteleraElorrieta.bbdd.pojos.Cliente;
import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Entrada;

class TestFinal {

	@Test
	void comprobarIntroducirEntradaNull() {
		Cliente cliente = new Cliente();
		Entrada entradaParaRegistrar = new Entrada();
		Emision emision = new Emision();
		GestorBBDD gestorBBDD = new GestorBBDD();

		emision.setCod_emision(1);
		entradaParaRegistrar.setEmision(emision);
		cliente.setDni("20982629A");
		entradaParaRegistrar.setCliente(cliente);
		entradaParaRegistrar.setCod_entrada(40);
		boolean entradaNoExiste = gestorBBDD.comprobarEntrada(entradaParaRegistrar);

		assertFalse(entradaNoExiste);

	}

	@Test
	void comprobarIntroducirEntradaNotNull() {
		Cliente cliente = new Cliente();
		Entrada entradaParaRegistrar = new Entrada();
		Emision emision = new Emision();
		GestorBBDD gestorBBDD = new GestorBBDD();

		emision.setCod_emision(1);
		cliente.setDni("20982629A");
		entradaParaRegistrar.setEmision(emision);
		entradaParaRegistrar.setCliente(cliente);
		entradaParaRegistrar.setCod_entrada(40);
		gestorBBDD.insertarEntradaClienteTest(entradaParaRegistrar);

		boolean entradaExiste = gestorBBDD.comprobarEntrada(entradaParaRegistrar);
		assertTrue(entradaExiste);

	}

	@Test
	void comprobarCreacionTicket() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_d HH-mm-ss");
		String date = dateFormat.format(new Date());
		final String NOMBRE_FICHERO = "Ticket " + date + ".txt";
		final String RUTA_FICHERO = "/reto3/src/carteleraElorrieta/tickets";
		File fichero = new File(RUTA_FICHERO + NOMBRE_FICHERO);
		boolean creacionFichero=false;
		try {
			
			// A partir del objeto File creamos el fichero físicamente
			if (fichero.createNewFile())
				creacionFichero=true;
			else
				creacionFichero=false;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		assertTrue(creacionFichero);
		
	}

}

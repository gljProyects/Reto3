package carteleraElorrieta.bbdd.gestor;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;

import carteleraElorrieta.bbdd.pojos.Cine;
import carteleraElorrieta.bbdd.pojos.Cliente;
import carteleraElorrieta.bbdd.pojos.Emision;
import carteleraElorrieta.bbdd.pojos.Entrada;
import carteleraElorrieta.bbdd.pojos.Pelicula;
import carteleraElorrieta.bbdd.pojos.Sala;
import carteleraElorrieta.bbdd.utils.DBUtils;

import java.sql.PreparedStatement;

// Clase para trabajar con la tabla alumno
public class GestorBBDD {

	// Retorna todas las filas de la tabla alumno
	// Si no hay nada, retorna NULL
	public ArrayList<Pelicula> sacarPeliculasPorCine(String cineSeleccionado) {

		ArrayList<Pelicula> ret = null;

		// SQL que queremos lanzar
		String sql = "select * " + "from pelicula p join emision e on p.cod_pelicula=e.cod_pelicula "
				+ "join sala s on s.cod_sala=e.cod_sala " + "join cine c on s.cod_cine=c.cod_cine "
				+ "where c.nombre= ? " + "group by p.nombre " + "order by fecha,horario ";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cineSeleccionado);
			resultSet = preparedStatement.executeQuery();

			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Pelicula>();

				Pelicula pelicula = new Pelicula();

				// Sacamos las columnas del RS
				int cod_pelicula = resultSet.getInt("cod_pelicula");
				int duracion = resultSet.getInt("duracion");
				String genero = resultSet.getString("genero");
				String nombre = resultSet.getString("nombre");

				// Metemos los datos a Ejemplo
				pelicula.setCod_pelicula(cod_pelicula);
				pelicula.setDuracion(duracion);
				pelicula.setGenero(genero);
				pelicula.setNombre(nombre);
				// Lo guardamos en ret
				ret.add(pelicula);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

	public ArrayList<Cine> sacarTodosLosCiness() {
		ArrayList<Cine> ret = null;

		// SQL que queremos lanzar
		String sql = "select * " + "from cine";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Cine>();

				Cine cine = new Cine();

				// Sacamos las columnas del RS
				int cod_cine = resultSet.getInt("cod_cine");
				String direccion = resultSet.getString("direccion");
				String nombre = resultSet.getString("nombre");

				// Metemos los datos a Ejemplo
				cine.setCod_cine(cod_cine);
				cine.setDireccion(direccion);
				cine.setNombre(nombre);
				// Lo guardamos en ret
				ret.add(cine);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

	public ArrayList<Emision> sacarEmisionesPorPeliculas(String peliculaSeleccionada, String cineSeleccionado) {
		ArrayList<Emision> ret = null;

		// SQL que queremos lanzar
		String sql = "select * " + "from emision e " + "join pelicula p on e.cod_pelicula=p.cod_pelicula "
				+ "join sala s on e.cod_sala=s.cod_sala " + "join cine c on s.cod_cine=c.cod_cine "
				+ "where p.nombre=? and c.nombre=? " + "group by fecha";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, peliculaSeleccionada);
			preparedStatement.setString(2, cineSeleccionado);
			resultSet = preparedStatement.executeQuery();

			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Emision>();

				Emision emision = new Emision();

				// Sacamos las columnas del RS
				int cod_emision = resultSet.getInt("cod_emision");
				Date fecha = resultSet.getDate("fecha");
				java.sql.Time horarioSql = resultSet.getTime("horario");
				LocalTime horario = horarioSql.toLocalTime();
				int precio = resultSet.getInt("precio");

				// Metemos los datos a Ejemplo
				emision.setCod_emision(cod_emision);
				emision.setFecha(fecha);
				emision.setHorario(horario);
				emision.setPrecio(precio);
				// Lo guardamos en ret
				ret.add(emision);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

	public ArrayList<Emision> sacarEmisionesPorFecha(String fechaSeleccionada, String peliculaSeleccionada,
			String cineSeleccionado) {
		ArrayList<Emision> ret = null;

		// SQL que queremos lanzar
		String sql = "select * " + "from emision e " + "join sala s on e.cod_sala=s.cod_sala "
				+ "join pelicula p on e.cod_pelicula=p.cod_pelicula " + "join cine c on s.cod_cine=c.cod_cine"
				+ " where fecha=? and p.nombre=? and c.nombre=?";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, fechaSeleccionada);
			preparedStatement.setString(2, peliculaSeleccionada);
			preparedStatement.setString(3, cineSeleccionado);
			resultSet = preparedStatement.executeQuery();

			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Emision>();

				Emision emision = new Emision();

				// Sacamos las columnas del RS
				int cod_emision = resultSet.getInt("cod_emision");
				Date fecha = resultSet.getDate("fecha");
				java.sql.Time horarioSql = resultSet.getTime("horario");
				LocalTime horario = horarioSql.toLocalTime();
				int precio = resultSet.getInt("precio");
				Sala sala = new Sala();
				sala.setCod_sala(resultSet.getInt("cod_sala"));
				sala.setNombre(resultSet.getString("Nombre"));

				// Metemos los datos a Ejemplo

				emision.setCod_emision(cod_emision);
				emision.setFecha(fecha);
				emision.setHorario(horario);
				emision.setPrecio(precio);
				emision.setSala(sala);
				// Lo guardamos en ret
				ret.add(emision);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

	// Inserta un alumno
	public void insertarNuevoCliente(Cliente clienteParaRegistrar) {

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		Statement statement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();

			// Montamos la SQL
			String sql = "insert into cliente (nombre, apellidos, contraseña,dni,sexo) VALUES ('"
					+ clienteParaRegistrar.getNombre() + "', '" + clienteParaRegistrar.getApellidos() + "', '"
					+ clienteParaRegistrar.getContraseña() + "', '" + clienteParaRegistrar.getDni() + "', '"
					+ clienteParaRegistrar.getSexo() + "' )";

			// La ejecutamos...
			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}

		}
	}

	public boolean comprobarCliente(String dniLogin, String contraseñaLogin) {

		// SQL que queremos lanzar
		String sql = "select * from cliente where dni=? and contraseña=?";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dniLogin);
			preparedStatement.setString(2, contraseñaLogin);
			resultSet = preparedStatement.executeQuery();

			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			if (resultSet.next()) {

				return true;

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return false;
	}

	public void insertarEntradaCliente(Entrada entradaParaRegistrar) {

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		Statement statement = null;

		LocalDate fecha = LocalDate.now();

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();

			// Montamos la SQL

			String sql = "insert into entrada (dni_cliente,cod_emision,fecha_compra) VALUES ('"
					+ entradaParaRegistrar.getCliente().getDni() + "', '"
					+ entradaParaRegistrar.getEmision().getCod_emision() + "', '" + fecha.toString() + "' )";

			// La ejecutamos...
			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}

		}
	}

	public ArrayList<Entrada> sacarTodosLosDatosParaTicket(Entrada entradaParaRegistrar) {
		ArrayList<Entrada> ret = null;
		
		LocalDate fecha = LocalDate.now();

		// SQL que queremos lanzar
		String sql = "select * from emision emi join sala sal on emi.cod_sala=sal.cod_sala join pelicula pel on emi.cod_pelicula=pel.cod_pelicula join cine cin on sal.cod_cine=cin.cod_cine join entrada ent on ent.cod_emision=emi.cod_emision join cliente cli on ent.dni_cliente=cli.dni where cli.dni=? and ent.fecha_compra=?";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entradaParaRegistrar.getCliente().getDni());
			preparedStatement.setString(2, fecha.toString());
			resultSet = preparedStatement.executeQuery();
			
			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Entrada>();

				Entrada entrada = new Entrada();
				entrada.setCod_entrada(resultSet.getInt("cod_entrada"));
				entrada.setFecha_compra(resultSet.getDate("fecha_compra"));

				Cliente cliente = new Cliente();
				cliente.setDni(resultSet.getString("dni"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellidos(resultSet.getString("apellidos"));
				cliente.setSexo(resultSet.getString("sexo"));
				cliente.setContraseña(resultSet.getString("contraseña"));
				entrada.setCliente(cliente);

				Emision emision = new Emision();
				emision.setCod_emision(resultSet.getInt("cod_emision"));
				emision.setFecha(resultSet.getDate("fecha"));
				java.sql.Time horarioSql = resultSet.getTime("horario");
				LocalTime horario = horarioSql.toLocalTime();
				emision.setHorario(horario);
				emision.setPrecio(resultSet.getInt("precio"));

				Pelicula pelicula = new Pelicula();
				pelicula.setCod_pelicula(resultSet.getInt("cod_pelicula"));
				pelicula.setDuracion(resultSet.getInt("duracion"));
				pelicula.setNombre(resultSet.getString("nombre"));
				pelicula.setGenero(resultSet.getString("genero"));
				emision.setPelicula(pelicula);

				Sala sala = new Sala();
				sala.setCod_sala(resultSet.getInt("cod_sala"));
				sala.setNombre(resultSet.getString("nombre"));

				Cine cine = new Cine();
				cine.setCod_cine(resultSet.getInt("cod_cine"));
				cine.setDireccion(resultSet.getString("direccion"));
				cine.setNombre(resultSet.getString("nombre"));
				sala.setCine(cine);
				emision.setSala(sala);
				entrada.setEmision(emision);

				// Lo guardamos en ret
				ret.add(entrada);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}
}

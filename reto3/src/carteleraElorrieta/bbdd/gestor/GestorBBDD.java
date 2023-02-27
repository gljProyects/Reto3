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

public class GestorBBDD {

	public ArrayList<Pelicula> sacarPeliculasPorCine(String cineSeleccionado) {

		ArrayList<Pelicula> ret = null;

		String sql = "select * " + "from pelicula p join emision e on p.cod_pelicula=e.cod_pelicula "
				+ "join sala s on s.cod_sala=e.cod_sala " + "join cine c on s.cod_cine=c.cod_cine "
				+ "where c.nombre= ? " + "group by p.nombre " + "order by fecha,horario ";

		Connection connection = null;

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cineSeleccionado);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Pelicula>();

				Pelicula pelicula = new Pelicula();

				int cod_pelicula = resultSet.getInt("cod_pelicula");
				int duracion = resultSet.getInt("duracion");
				String genero = resultSet.getString("genero");
				String nombre = resultSet.getString("nombre");

				pelicula.setCod_pelicula(cod_pelicula);
				pelicula.setDuracion(duracion);
				pelicula.setGenero(genero);
				pelicula.setNombre(nombre);

				ret.add(pelicula);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return ret;
	}

	public ArrayList<Cine> sacarTodosLosCiness() {
		ArrayList<Cine> ret = null;

		String sql = "select * " + "from cine";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Cine>();

				Cine cine = new Cine();

				int cod_cine = resultSet.getInt("cod_cine");
				String direccion = resultSet.getString("direccion");
				String nombre = resultSet.getString("nombre");

				cine.setCod_cine(cod_cine);
				cine.setDireccion(direccion);
				cine.setNombre(nombre);

				ret.add(cine);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return ret;
	}

	public ArrayList<Emision> sacarEmisionesPorPeliculas(String peliculaSeleccionada, String cineSeleccionado) {
		ArrayList<Emision> ret = null;

		String sql = "select * " + "from emision e " + "join pelicula p on e.cod_pelicula=p.cod_pelicula "
				+ "join sala s on e.cod_sala=s.cod_sala " + "join cine c on s.cod_cine=c.cod_cine "
				+ "where p.nombre=? and c.nombre=? " + "group by fecha";

		Connection connection = null;

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, peliculaSeleccionada);
			preparedStatement.setString(2, cineSeleccionado);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Emision>();

				Emision emision = new Emision();

				int cod_emision = resultSet.getInt("cod_emision");
				Date fecha = resultSet.getDate("fecha");
				java.sql.Time horarioSql = resultSet.getTime("horario");
				LocalTime horario = horarioSql.toLocalTime();
				int precio = resultSet.getInt("precio");

				emision.setCod_emision(cod_emision);
				emision.setFecha(fecha);
				emision.setHorario(horario);
				emision.setPrecio(precio);

				ret.add(emision);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return ret;
	}

	public ArrayList<Emision> sacarEmisionesPorFecha(String fechaSeleccionada, String peliculaSeleccionada,
			String cineSeleccionado) {
		ArrayList<Emision> ret = null;

		String sql = "select * " + "from emision e " + "join sala s on e.cod_sala=s.cod_sala "
				+ "join pelicula p on e.cod_pelicula=p.cod_pelicula " + "join cine c on s.cod_cine=c.cod_cine"
				+ " where fecha=? and p.nombre=? and c.nombre=?";

		Connection connection = null;

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, fechaSeleccionada);
			preparedStatement.setString(2, peliculaSeleccionada);
			preparedStatement.setString(3, cineSeleccionado);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Emision>();

				Emision emision = new Emision();

				int cod_emision = resultSet.getInt("cod_emision");
				Date fecha = resultSet.getDate("fecha");
				java.sql.Time horarioSql = resultSet.getTime("horario");
				LocalTime horario = horarioSql.toLocalTime();
				int precio = resultSet.getInt("precio");
				Sala sala = new Sala();
				sala.setCod_sala(resultSet.getInt("cod_sala"));
				sala.setNombre(resultSet.getString("Nombre"));

				emision.setCod_emision(cod_emision);
				emision.setFecha(fecha);
				emision.setHorario(horario);
				emision.setPrecio(precio);
				emision.setSala(sala);

				ret.add(emision);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return ret;
	}

	public void insertarNuevoCliente(Cliente clienteParaRegistrar) {

		Connection connection = null;

		Statement statement = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into cliente (nombre, apellidos, contraseña,dni,sexo) VALUES ('"
					+ clienteParaRegistrar.getNombre() + "', '" + clienteParaRegistrar.getApellidos() + "', '"
					+ clienteParaRegistrar.getContraseña() + "', '" + clienteParaRegistrar.getDni() + "', '"
					+ clienteParaRegistrar.getSexo() + "' )";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}

		}
	}

	public boolean comprobarCliente(String dniLogin, String contrasenaLogin) {

		String sql = "select * from cliente where dni=? and contraseña=?";

		Connection connection = null;

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dniLogin);
			preparedStatement.setString(2, contrasenaLogin);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return true;

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return false;
	}

	public void insertarEntradaCliente(Entrada entradaParaRegistrar) {

		Connection connection = null;

		Statement statement = null;

		LocalDate fecha = LocalDate.now();

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into entrada (dni_cliente,cod_emision,fecha_compra) VALUES ('"
					+ entradaParaRegistrar.getCliente().getDni() + "', '"
					+ entradaParaRegistrar.getEmision().getCod_emision() + "', '" + fecha.toString() + "' )";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}

		}
	}

	public ArrayList<Entrada> sacarTodosLosDatosParaTicket(Entrada entradaParaRegistrar) {
		ArrayList<Entrada> ret = null;

		LocalDate fecha = LocalDate.now();

		String sql = "select cin.cod_cine,direccion,cin.nombre as nombrecine,dni,cli.nombre as nombrecliente,apellidos,contraseña,sexo,emi.cod_emision,fecha,horario,precio,pel.cod_pelicula,duracion,genero,pel.nombre as nombrepelicula,sal.cod_sala,sal.nombre as nombresala,ent.cod_entrada,fecha_compra from emision emi join sala sal on emi.cod_sala=sal.cod_sala join pelicula pel on emi.cod_pelicula=pel.cod_pelicula join cine cin on sal.cod_cine=cin.cod_cine join entrada ent on ent.cod_emision=emi.cod_emision join cliente cli on ent.dni_cliente=cli.dni where cli.dni=? and ent.fecha_compra=?";

		Connection connection = null;

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entradaParaRegistrar.getCliente().getDni());
			preparedStatement.setString(2, fecha.toString());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Entrada>();

				Entrada entrada = new Entrada();
				entrada.setCod_entrada(resultSet.getInt("cod_entrada"));
				entrada.setFecha_compra(resultSet.getDate("fecha_compra"));

				Cliente cliente = new Cliente();
				cliente.setDni(resultSet.getString("dni"));
				cliente.setNombre(resultSet.getString("nombrecliente"));
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
				pelicula.setNombre(resultSet.getString("nombrepelicula"));
				pelicula.setGenero(resultSet.getString("genero"));
				emision.setPelicula(pelicula);

				Sala sala = new Sala();
				sala.setCod_sala(resultSet.getInt("cod_sala"));
				sala.setNombre(resultSet.getString("nombresala"));

				Cine cine = new Cine();
				cine.setCod_cine(resultSet.getInt("cod_cine"));
				cine.setDireccion(resultSet.getString("direccion"));
				cine.setNombre(resultSet.getString("nombrecine"));
				sala.setCine(cine);
				emision.setSala(sala);
				entrada.setEmision(emision);

				ret.add(entrada);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return ret;
	}

	public boolean comprobarEntrada(Entrada entradaParaRegistrar) {

		String sql = "select * from entrada where dni_cliente=? and cod_emision=? and cod_entrada=?";

		Connection connection = null;

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entradaParaRegistrar.getCliente().getDni());
			preparedStatement.setInt(2, entradaParaRegistrar.getEmision().getCod_emision());
			preparedStatement.setInt(3, entradaParaRegistrar.getCod_entrada());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return true;

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return false;
	}

	public void insertarEntradaClienteTest(Entrada entradaParaRegistrar) {

		Connection connection = null;

		Statement statement = null;

		LocalDate fecha = LocalDate.now();

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into entrada (cod_entrada,dni_cliente,cod_emision,fecha_compra) VALUES ('"
					+ entradaParaRegistrar.getCod_entrada() + "','" + entradaParaRegistrar.getCliente().getDni()
					+ "', '" + entradaParaRegistrar.getEmision().getCod_emision() + "', '" + fecha.toString() + "' )";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}

		}
	}
}

package carteleraElorrieta.bbdd.gestor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;

import carteleraElorrieta.bbdd.pojos.Pelicula;
import carteleraElorrieta.bbdd.utils.DBUtils;

// Clase para trabajar con la tabla alumno
public class GestorBBDD {

	// Retorna todas las filas de la tabla alumno
	// Si no hay nada, retorna NULL
	public ArrayList<Pelicula> sacarTodasLasPeliculas() {
		ArrayList<Pelicula> ret = null;

		// SQL que queremos lanzar
		String sql = "select * from pelicula p join emision e on p.cod_pelicula=e.cod_pelicula join sala s on s.cod_sala=e.cod_sala where cod_cine=1";

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


}

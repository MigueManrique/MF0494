package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Infractor;
import modelo.Sancion;

public class InfractorDAO {


	private ConexionBD conexion;
	
    public InfractorDAO() {
        this.conexion = new ConexionBD();
    }


    public ArrayList<Infractor> obtenerInfractores() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Infractor> lista = new ArrayList<Infractor>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from infractores");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				int dni = resultado.getInt("dni");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				int antiguedad = resultado.getInt("antiguedad");
				float sancion = resultado.getFloat("sancion");
				int puntos = resultado.getInt("puntos");
				
				Infractor in = new Infractor(dni, nombre, apellidos, antiguedad, sancion, puntos);
				lista.add(in);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre infractores: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
    }

    


    public int insertarInfractor(Infractor in) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO INFRACTORES (dni, nombre, apellidos, antiguedad, sancion, puntos)"
					+ " VALUES (?,?,?,?,?,?) ");
			consulta.setInt(1, in.getDni());
			consulta.setString(2, in.getNombre());
			consulta.setString(2, in.getApellidos());
			consulta.setInt(4, in.getAntiguedad());
			consulta.setFloat(5, in.getSancion());
			consulta.setInt(6, in.getPuntos());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción de un infractor: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }

   

}

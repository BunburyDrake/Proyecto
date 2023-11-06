package Celular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DataCelular {
	Connection cx;

	public static void main(String[] ola) {
		DataCelular da = new DataCelular();
		da.conectar();
	}

	public DataCelular() {
	}

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/celular", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("FALLO CONEXION");
			e.printStackTrace();
		}
		return cx;
	}

	public boolean insertarCel(Celular p) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO celular VALUES(?,?,?,?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getMarca());
			ps.setString(3, p.getModelo());
			ps.setString(4, p.getSistema());
			ps.setString(5, p.getProcesador());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean cargarCel(Celular c) {
		PreparedStatement ps;
		ResultSet rs=null;
		try {
			ps=conectar().prepareStatement("SELECT * FROM celular WHERE id=?");
			ps.setInt(1, c.getId());
			rs=ps.executeQuery();
			if(rs.next()) {
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setProcesador(rs.getString(4));
				c.setSistema(rs.getString(5));
				return true;
			}else {
				return false;	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}

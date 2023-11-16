package Celular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






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
	public ArrayList<Celular> selectCelulares() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Celular> listaCelulares=new ArrayList<Celular>();
        try {
            ps = conectar().prepareStatement("SELECT * FROM celular");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Celular c=new Celular();
                c.setId(rs.getInt(1));
                c.setMarca(rs.getString(2));
                c.setModelo(rs.getString(3));
                c.setSistema(rs.getString(4));
                c.setProcesador(rs.getString(5));
                listaCelulares.add(c);
            }
        } catch (Exception e) {
        }
        return listaCelulares;
    }
	
	public boolean actualizarCel(Celular c) {
		PreparedStatement ps;
		try {
			Celular x=new Celular();
			x.setId(c.getId());
			if(x.cargarCel()) {
			ps = conectar().prepareStatement("UPDATE celular SET Marca=?,Modelo=?,Sistema=?,Procesador=? WHERE id=?");
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setString(3, c.getProcesador());
			ps.setString(4, c.getSistema());	
			ps.setInt(5, c.getId());
			ps.execute();
			return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
public boolean eliminarCel(int idcel) {
		PreparedStatement ps;
		try {
			Celular x=new Celular();
			x.setId(idcel);
			if(x.cargarCel()) {
			ps = conectar().prepareStatement("DELETE FROM celular WHERE id=?");
			ps.setInt(1,idcel);
			ps.execute();
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

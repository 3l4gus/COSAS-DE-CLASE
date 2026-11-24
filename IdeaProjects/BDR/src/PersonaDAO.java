

import java.sql.*;
import java.util.ArrayList;

public class PersonaDAO {

	private ConexionBD conexionBD;

	public PersonaDAO(ConexionBD conexionBD) {
		this.conexionBD = conexionBD;
	}

	public boolean darDeAltaPersona(PersonaEntity persona) throws SQLException {

        String sql = "insert into persona(nombre, apellidos, edad) values (?,?,?);";

   //     String sql = "insert into persona(nombre, apellidos, edad) values ( "+ persona.getNombre()  + ", "?);";

       Connection con = conexionBD.abrirConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, persona.getNombre());
        ps.setString(2, persona.getApellidos());
        ps.setInt(3, persona.getEdad());

        int res = ps.executeUpdate();

        ps.close();

        return res > 0;

	}

	// 2. ELIMINAR POR ID
	public boolean eliminarPersona(int id) throws SQLException {

        String delete = "delete from persona where id = ?";
        Connection con = conexionBD.abrirConexion();

        PreparedStatement ps = con.prepareStatement(delete);

        ps.setInt(1, id);

        int res = ps.executeUpdate();
        ps.close();

        return res > 0;
	}


	// 3. CONSULTAR POR ID
	public PersonaEntity consultarPersonaPorId(int id) throws SQLException {

        String sql = "select * from persona where id = ?;";

        Connection con = conexionBD.abrirConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

         ResultSet rs = ps.executeQuery();

         PersonaEntity pe = new PersonaEntity();

         if(rs.next()){

             pe.setId(rs.getInt("id"));
             pe.setEdad(rs.getInt("edad"));
             pe.setNombre(rs.getString("nombre"));
             pe.setApellidos(rs.getString("apellidos"));

         }

        ps.close();

		return pe;
	}


	// 4. LISTADO DE TODAS LAS PERSONAS
	public ArrayList<PersonaEntity> listarPersonas() throws SQLException {

        String sql = "select * from persona";

        ArrayList<PersonaEntity> listaPersonas = new ArrayList<>();

        Connection con = conexionBD.abrirConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            PersonaEntity pe = new PersonaEntity();

            pe.setId(rs.getInt("id"));
            pe.setEdad(rs.getInt("edad"));
            pe.setNombre(rs.getString("nombre"));
            pe.setApellidos(rs.getString("apellidos"));

            listaPersonas.add(pe);
        }

        ps.close();

        return listaPersonas;
	}


	// 5. MODIFICAR PERSONA
	public boolean modificarPersona(PersonaEntity persona) throws SQLException {

        String sql = "update persona set nombre = ?, apellidos = ?, edad = ? where id = ?";

        Connection con = conexionBD.abrirConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, persona.getNombre());
        ps.setString(2, persona.getApellidos());
        ps.setInt(3, persona.getEdad());
        ps.setInt(4, persona.getId());

        int res = ps.executeUpdate();

        ps.close();

        return res > 0;
    }

}

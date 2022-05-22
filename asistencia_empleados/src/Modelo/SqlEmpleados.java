
package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlEmpleados extends Conexion{
    
    public boolean registrar(Empleados empl){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO empleados (cedula, nombres, apellidos, correo, direccion, telefono, fecha_nacimiento,estado) VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, empl.getCedula());
            ps.setString(2, empl.getNombres());
            ps.setString(3, empl.getApellidos());
            ps.setString(4, empl.getCorreo());
            ps.setString(5, empl.getDireccion());
            ps.setString(6, empl.getTelefono());
            ps.setString(7, empl.getFecha_nacimiento());
            ps.setString(8, empl.getEstado());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int consultarEmpleado(String usr){
       PreparedStatement ps = null;
       ResultSet rs = null;
       Connection con = getConexion();
       
       String sql = "SELECT count(cedula) FROM empleados WHERE empleados = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usr);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SqlEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    
    public boolean validaEmail(String correo){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,4})$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }
    
    public boolean loginUsuario(Empleados empl){
        
    }
}

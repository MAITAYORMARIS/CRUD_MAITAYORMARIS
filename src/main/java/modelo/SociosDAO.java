/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yormaris_maita
 */
public class SociosDAO 
{
    Connection conexion;
    
    public SociosDAO() throws ClassNotFoundException
    {
        Conexion con=new Conexion();
        conexion=con.getConnection();
    }
    
    public List<Socios> listarSocios()
    {
        PreparedStatement ps;
        ResultSet rs;
        List <Socios> lista=new ArrayList <>();
        
        try
        {
            ps=conexion.prepareStatement("select * from socios");
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                int id=rs.getInt("idSocio");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String direccion=rs.getString("direccion");
                String localidad=rs.getString("localidad");
                LocalDate fecha=rs.getDate("fechaNac").toLocalDate();
                String mail=rs.getString("mail");
                String telefono=rs.getString("telefono");
                Boolean activo=rs.getBoolean("activo");
                
                             
                Socios socioNuevo=new Socios(id,nombre,apellido,direccion,localidad,fecha,mail,telefono,activo);
                lista.add(socioNuevo);
            }
            
        }
        
        catch (SQLException e)
        {
            System.out.println(e);
            //return null;
        }
        return lista;
    }
    
    
    public Socios mostrarSocio(int _id)
    {
        PreparedStatement ps;
        ResultSet rs;
        Socios socioNuevo=null;
        
        try
        {
            ps=conexion.prepareStatement("select * from socios where idSocio=?");
            ps.setInt(1, _id);
            rs=ps.executeQuery();
            
             while(rs.next())
            {
                int id=rs.getInt("idSocio");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String direccion=rs.getString("direccion");
                String localidad=rs.getString("localidad");
                LocalDate fechaNac=rs.getDate("fechaNac").toLocalDate();
                String mail=rs.getString("mail");
                String telefono=rs.getString("telefono");
                boolean activo=rs.getBoolean("activo");
                                            
                socioNuevo=new Socios(id,nombre,apellido,direccion,localidad,fechaNac,mail,telefono,activo);
               
            }
            return socioNuevo;
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return null;
        }
            
    }
    
    public boolean insertarSocios(Socios socioNuevo)
    {
        PreparedStatement ps;
        try
        {
           ps=conexion.prepareStatement("insert into socios(nombre,apellido, direccion,localidad, fechaNac,mail,telefono,activo) values(?,?,?,?,?,?,?,?)");
           ps.setString(1,socioNuevo.getNombre() );
           ps.setString(2, socioNuevo.getApellido());
           ps.setString(3, socioNuevo.getDireccion());
           ps.setString(4, socioNuevo.getLocalidad());
           ps.setObject(5, socioNuevo.getFechaNac());
           ps.setString(6, socioNuevo.getMail());
           ps.setString(7, socioNuevo.getTelefono());
           ps.setBoolean(8, true);
           ps.execute();
           return true;
        }
        
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
        
           
    public boolean actualizarSocios(Socios socioNuevo)
    {
        PreparedStatement ps;
        try
        {
           ps=conexion.prepareStatement("update socios set nombre=?,apellido=?, direccion=?,localidad=?, fechaNac=?,mail=?,telefono=?,activo=? where idSocio=?");
           ps.setString(1,socioNuevo.getNombre() );
           ps.setString(2, socioNuevo.getApellido());
           ps.setString(3, socioNuevo.getDireccion());
           ps.setString(4, socioNuevo.getLocalidad());
           ps.setObject(5, socioNuevo.getFechaNac());
           ps.setString(6, socioNuevo.getMail());
           ps.setString(7, socioNuevo.getTelefono());
           ps.setBoolean(8, socioNuevo.isActivo());
           ps.setInt(9, socioNuevo.getIdSocio());
           ps.execute();
           return true;
        }
        
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
   
    }
    
    public boolean eliminarSocio(int _id)
    {
        PreparedStatement ps;
        try
        {
            ps=conexion.prepareStatement("delete from socios where idSocio=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    

}

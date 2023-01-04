/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Socios;
import modelo.SociosDAO;

/**
 *
 * @author y_mai
 */
//@WebServlet(name = "SociosControllerMY", urlPatterns = {"/SociosControllerMY"})
public class SociosController1 extends HttpServlet 
{
    public SociosController1()
    {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       SociosDAO sociosDAO=null;
       try
       {
       sociosDAO=new SociosDAO();
       }
       
       catch (ClassNotFoundException e)
       {
       System.out.println(e);
       }
       
       String accion;
       RequestDispatcher dispatcher=null;
       
       accion=request.getParameter("accion") ;
       
       if(accion==null||accion.isEmpty())
       {
           dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
       }
       
       else if(accion.equals("modificar"))
       {
           dispatcher=request.getRequestDispatcher("vistas/modificar.jsp");
       }
       else if(accion.equals("actualizar"))
       {
           int id=Integer.parseInt(request.getParameter("id"));
           String nombre=request.getParameter("nombre");
           String apellido=request.getParameter("apellido");
           String direccion=request.getParameter("direccion");
           String localidad=request.getParameter("localidad");
           LocalDate fecha=LocalDate.parse(request.getParameter("fechaNac"));
           String mail=request.getParameter("mail");
           String telefono=request.getParameter("telefono");  
           
           Socios socioNuevo=new Socios(id,nombre,apellido,direccion,localidad,fecha,mail,telefono,true);
           sociosDAO.actualizarSocios(socioNuevo);
           dispatcher=request.getRequestDispatcher("vistas/socios.jsp");

       }
       else if(accion.equals("eliminar"))
       {
           int id=Integer.parseInt(request.getParameter("id"));
           sociosDAO.eliminarSocio(id);
           dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
           
       }
       else if(accion.equals("nuevo"))
       {
           dispatcher=request.getRequestDispatcher("vistas/nuevo.jsp");
       }
       else if(accion.equals("insertar"))
       {
           String nombre=request.getParameter("nombre");
           String apellido=request.getParameter("apellido");
           String direccion=request.getParameter("direccion");
           String localidad=request.getParameter("localidad");
           LocalDate fecha =LocalDate.parse(request.getParameter("fechaNac"));
           String mail=request.getParameter("mail");
           String telefono=request.getParameter("telefono");  
           
           Socios socioNuevo=new Socios(0,nombre,apellido,direccion,localidad,fecha,mail,telefono,true);
           sociosDAO.insertarSocios(socioNuevo);
           dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
       }
       dispatcher.forward(request, response);
               
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doGet(request,response);
    }
   

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

<%-- 
    Document   : socios
    Created on : 30 dic 2022, 23:22:06
    Author     : y_mai
--%>

<%@page import="modelo.SociosDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Socios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <title>Socios</title>
    </head>
    <body>
        <header style="height:150px; background-color: black; ">
            <p class="h1 text-center info"  "><small >Listado de Socios del GYM</small></p><br><br>
            
            <div class="d-grid gap-3 d-md-flex justify-content-center">
                
            
                <a class="btn btn-outline-primary " href="SociosControllerN?accion=nuevo"
                   style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem">Agregar Socio</a>
            </div>
        </header>
        <main>

            <div class="container" style="margin-top:70px">
                <div class="row">


                    <table class="table table-dark table-striped">
                        <thead>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Direccion</th>
                        <th>Localidad</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Correo Electronico</th>
                        <th>Telefono</th>
                        <th>Modificar</th>
                        <th>Eliminar</th>

                        </thead>
                        <%
                            List<Socios> resultado = null;
                            SociosDAO socioNuevo = new SociosDAO();
                            resultado = socioNuevo.listarSocios();

                            for (int x = 0; x < resultado.size(); x++) {
                                String rutaMod = "SociosControllerN?accion=modificar&id=" + resultado.get(x).getIdSocio();
                                String rutaElim = "SociosControllerN?accion=eliminar&id=" + resultado.get(x).getIdSocio();

                        %>
                        <tr>
                            <td> <%=resultado.get(x).getIdSocio()%></td>
                            <td> <%=resultado.get(x).getNombre()%></td>
                            <td> <%=resultado.get(x).getApellido()%></td>
                            <td><%=resultado.get(x).getDireccion()%></td>
                            <td><%=resultado.get(x).getLocalidad()%></td>
                            <td><%=resultado.get(x).getFechaNac()%></td>
                            <td><%=resultado.get(x).getMail()%></td>
                            <td><%=resultado.get(x).getTelefono()%></td>
                            <td><a href=<%=rutaMod%> ><i class="fa-solid fa-file-pen"></i></a></td>
                            <td><a href=<%=rutaElim%> ><i class="fa-solid fa-trash"></i></a></td>
                        </tr>
                        <%
                            }
                        %>

                    </table>



                </div>
            </div>
        </main><!-- Fin del cuerpo -->
        <footer>

        </footer>

    </body>
</html>


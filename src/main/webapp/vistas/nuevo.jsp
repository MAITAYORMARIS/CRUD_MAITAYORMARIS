<%-- 
    Document   : nuevo
    Created on : 30 dic 2022, 23:21:55
    Author     : y_mai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Nuevo Socio</title>
    </head>
    <body>
        <header style="height:150px; background-color: black; ">
            <p class="h1 text-center info"  "><small >Registro de Nuevo Socio</small></p><br><br>
            
            <div class="d-grid gap-3 d-md-flex justify-content-center">
                <a class="btn btn-outline-primary " href="SociosControllerN" style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem">Volver</a>
            </div>
        </header>


        <main>
            <div class="container" style="margin-top: 30px">       
                
                <form class="row g-3" method="POST" action="SociosControllerN?accion=insertar">
                    <div class="col-md-6">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese nombre del Socio">
                    </div>
                    <div class="col-md-6">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingrese apellido del Socio">
                    </div>
                    <div class="col-12">
                        <label for="direccion" class="form-label">Direccion</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" placeholder="Ingrese la direccion">
                    </div>
                    <div class="col-12">
                        <label for="localidad" class="form-label">Localidad</label>
                        <input type="text" class="form-control" id="localidad" name="localidad" placeholder="Ingrese la localidad">
                    </div>
                    <div class="col-4">
                        <label for="fechaNac" class="form-label">Fecha de Nacimiento</label>
                        <input type="date" class="form-control" id="fechaNac" name="fechaNac">
                    </div>

                    <div class="col-md-4">
                        <label for="mail" class="form-label">Mail</label>
                        <input type="text" class="form-control" id="mail" name="mail" placeholder="Ingrese el correo electronico">
                    </div>
                    <div class="col-md-4">
                        <label for="telefono" class="form-label">Telefono</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Ingrese un numero de contacto">
                    </div>
                   
                    <div class="col-12">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="gridCheck">
                            <label class="form-check-label" for="gridCheck">
                                Registrar Socio
                            </label>
                        </div>
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-outline-light"
                                style="--bs-btn-padding-y: .5rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem">Registrar</button>
                    </div>
                </form>

            </div>
        </main>

    </body>
</html>

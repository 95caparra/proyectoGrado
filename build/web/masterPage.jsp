<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.com.blummer.quotevent.modelo.vo.SolicitudVO"%>
<%@page import="java.util.Iterator"%>
<!-- Código para validar sesion -->
<%@ page session="true" %>
<%
    HttpSession sessionOK = request.getSession();
    String usuario = (String) sessionOK.getAttribute("usuario");
    String rol = (String) sessionOK.getAttribute("rol");
    if (usuario == null || usuario.equals("") || !rol.equals("1") || rol == null) {
        sessionOK.setAttribute("mensaje", "");
%>
<jsp:forward page="login.jsp">
    <jsp:param name="error" value="error"/>
</jsp:forward>
<%
    }
%>
<!-- //Fin código para validar sesion -->

<%
    String empleado = (String) sessionOK.getAttribute("empleado");
    ArrayList solicitudes = (ArrayList) request.getAttribute("listaSolicitud");
%>
<html>
    <head>
        <title>Quotevent</title>
        <link rel="icon" type="image/png" href="images/favicon.png" />

        <link rel="stylesheet" type="text/css" href="css/estilos.css" media="screen">
        <link rel="stylesheet" href="css/coda-slider.css" type="text/css" media="screen" charset="utf-8" />

        <!-- Add jQuery library -->
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

        <!-- Agregamos el script de las funciones basicas -->
        <script type="text/javascript" src="js/funciones.js"></script>
        <script type="text/javascript" src="js/funcionesUsuario.js"></script>
        <script type="text/javascript" src="js/cnnServlet.js"></script>

        <!--librerias mensajes-->
        <link rel="stylesheet" href="css/messi.min.css" />
        <script src="js/messi.min.js"></script>

        <!-- Add fancyBox main JS and CSS files -->
        <script type="text/javascript" src="js/jquery.fancybox.js"></script>
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css" media="screen" />

        <script type="text/javascript">
            /* function onCargarLista(lista) {
             var divLista = $('#infoIzquierdo').html('');
             var div;
             $.each(lista, function(i, item) {
             if (item.visto === 1) {
             div = '<div class="elemento" onClick="cargaDetalle(' + "\'controladorSolicitudes\'" + ',' + item.idSolicitud + ', 2, ' +
             "\'formSolicitudes\'" + ',$(this))" >' + item.nombreCliente + '</div>';
             } else {
             div = '<div class="elementoNoVisto" onClick="cargaDetalle(' + "\'controladorSolicitudes\'" + ',' + item.idSolicitud + ', 2, ' +
             "\'formSolicitudes\'" + ',$(this))" >' + item.nombreCliente + '</div>';
             }
             
             divLista.append(div);
             });
             
             $('#inline1').html('');
             $('#inline2').html('');
             }*/
        </script>

        <link type="text/css" rel="stylesheet" href="css/estiloPaginate.css" />
        <script type="text/javascript" src="js/jquery.pajinate.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#paging_container1').pajinate();
            });
            $(document).ready(function () {
                $('#paging_container2').pajinate();
            });
            $(document).ready(function () {
                $('#paging_container3').pajinate({
                    items_per_page: 5,
                    item_container_id: '.alt_content',
                    nav_panel_id: '.alt_page_navigation'

                });
            });
            $(document).ready(function () {
                $('#paging_container4').pajinate();
            });
            $(document).ready(function () {
                $('#paging_container5').pajinate({
                    nav_label_first: '<<',
                    nav_label_last: '>>',
                    nav_label_prev: '<',
                    nav_label_next: '>'
                });
            });
            $(document).ready(function () {
                $('#paging_container6').pajinate({
                    start_page: 2,
                    items_per_page: 5
                });
            });
            $(document).ready(function () {
                $('#paging_container7').pajinate({
                    num_page_links_to_display: 3,
                    items_per_page: 6
                });
            });
            $(document).ready(function () {
                $('#paging_container8').pajinate({
                    num_page_links_to_display: 3,
                    items_per_page: 6
                });
            });
            $(document).ready(function () {
                $('#paging_container9').pajinate({
                    num_page_links_to_display: 3,
                    items_per_page: 6,
                    wrap_around: true,
                    show_first_last: false
                });
            });
            $(document).ready(function () {
                $('#paging_container10').pajinate({
                    items_per_page: 6,
                    abort_on_small_lists: true
                });
            });
            $(document).ready(function () {
                $('#paging_container11').pajinate();
            });</script>


        <script type="text/javascript">
            function cargarUsuarios(opcion) {

                $.post('controladorUsuarios', {
                    opcion: opcion
                }, function (responseText) {
                    $("#contenedorUsuarios").html(responseText);
                });
                $(".fancybox").fancybox();
            }
        </script>

    </head>
    <body>


        <%  if (session.getAttribute("mensaje") != null) {
        %> 
        <script type=text/javascript>new Messi('<%=session.getAttribute("mensaje")%>', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});</script>
        <%
            }
            session.setAttribute("mensaje", null);
        %>
        <div id="barraInicio">
            <div id="menuHeader">
                <a class="fancybox" href="#inline3" onclick="ayuda(5)">
                    <img src="img/ayuda.png" title="Ayuda">
                </a>
                <% if (rol.equals("1")) {
                %>
                <a class="fancybox" href="#contenedorUsuarios" onclick="cargarUsuarios(1)">
                    <img src="img/usuarios.png" title="Gestión de usuarios">
                </a>
                <%
                    }
                %>
                <a class="fancybox" href="#contenedorClave" onclick="cambiarClave(6)">
                    <img src="img/tuerca.png" title="Cambiar clave" width="30" height="30">
                </a>
                <div id="opcMenuHeader" >
                    Cerrar sesion
                    <a href="#" onclick="cerraSesion(2)"><img src="img/salir.png" /></a>
                </div>
            </div>	
        </div>

        <div id="contenedor">
            <form method="POST" action="login" id="formCerrarSesion">
                <input type="hidden" name="opcion" value="2" /> 
            </form>

            <div id="header">
                <div id="logo">
                    <img src="img/logo.png" />
                </div>
                <div id="infoUsuario">
                    <img src="img/user.png" />
                    <div class="textoUsuario">
                        <p>BIENVENIDO GERENTE</p><%=empleado%>
                    </div> 
                </div>
            </div>

            <div id="contenedorDerecho">
                <form method="POST" action="controlador" id="menu">
                    <input type="hidden" name="opcion" value="" />
                    <ul class="navigation">
                        <% if (rol.equals("1")) {%>
                        <li><a href="#" onclick="defineOpcion(11)" class="selected">Solicitudes<span class="ui_icon solicitud"></span></a></li>
                                <%}
                            if (rol.equals("2")) {%>
                        <li><a href="#" onclick="defineOpcion(25)" class="selected">Solicitudes<span class="ui_icon solicitud"></span></a></li>
                                <%}
                            if (rol.equals("3")) {%>
                        <li><a href="#" onclick="defineOpcion(26)" class="selected">Solicitudes<span class="ui_icon solicitud"></span></a></li>
                                <%}
                            if (rol.equals("4")) {%>
                        <li><a href="#" onclick="defineOpcion(27)" class="selected">Solicitudes<span class="ui_icon solicitud"></span></a></li>
                                <%}
                            if (rol.equals("5")) {%>
                        <li><a href="#" onclick="defineOpcion(28)" class="selected">Solicitudes<span class="ui_icon solicitud"></span></a></li>
                                <%}
                            if (rol.equals("6")) {%>
                        <li><a href="#" onclick="defineOpcion(29)" class="selected">Solicitudes<span class="ui_icon solicitud"></span></a></li>
                                <%}%>
                                <%
                                    if (rol.equals("1") || rol.equals("2")) {
                                %>
                        <li><a href="#" onclick="defineOpcion(12)">Eventos<span class="ui_icon evento"></span></a>
                            <ul>
                                <li onclick="defineOpcion(22)">Abonados</li>
                                <li onclick="defineOpcion(21)">Aprobados</li>
                                <li onclick="defineOpcion(23)">Cancelados</li>
                                <li onclick="defineOpcion(24)">Finalizados</li>
                            </ul>
                        </li>
                        <%
                            }
                        %>  
                        <% if (rol.equals("1") || rol.equals("2") || rol.equals("3")) {
                        %>
                        <li><a href="#" onclick="defineOpcion(2)">Clientes<span class="ui_icon cliente"></span></a></li>
                        <li><a href="#" onclick="defineOpcion(9)">Paquetes<span class="ui_icon paquete"></span></a></li>
                                <%
                                    }
                                %>
                        <li><a href="#" onclick="defineOpcion(17)">Catálogos<span class="ui_icon catalogo"></span></a>
                            <ul>
                                <li onclick="defineOpcion(18)">Platos</li>
                                <li onclick="defineOpcion(19)">Bebidas</li>
                                <li onclick="defineOpcion(20)">Servicios</li>
                            </ul>
                        </li>

                        <li><a href="#" onclick="defineOpcion(4)">Stock<span class="ui_icon producto"></span></a>
                            <ul>
                                <li onclick="defineOpcion(6)">Menaje</li>
                                <li onclick="defineOpcion(7)">Alimento</li>
                                <li onclick="defineOpcion(5)">Licor</li>
                            </ul>
                        </li>
                        <li><a href="#" onclick="defineOpcion(3)">Proveedores<span class="ui_icon proveedor"></span></a></li>
                        <li><a href="#" onclick="defineOpcion(8)">Empleados<span class="ui_icon empleado"></span></a></li>
                        <li><a href="#" onclick="defineOpcion(14)">Pedidos<span class="ui_icon pedido"></span></a></li>
                    </ul>
                </form>
            </div>
            
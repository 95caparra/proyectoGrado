<%@page import="co.com.blummer.quotevent.modelo.vo.PaqueteVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.com.blummer.quotevent.modelo.vo.ProductoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../../masterPage.jsp" />
<!-- Código para validar sesion -->
<%@ page session="true" %>
<%
    HttpSession sessionOK = request.getSession();
    String usuario = (String) sessionOK.getAttribute("usuario");
    String rol = (String) sessionOK.getAttribute("rol");
    if (usuario == null || usuario.equals("") || !rol.equals("1") && !rol.equals("2") && !rol.equals("3") && !rol.equals("4") && !rol.equals("5") && !rol.equals("6") || rol == null) {
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
    ArrayList paquetes = (ArrayList) request.getAttribute("listaPaquetes");
%>

<div id="contenedorIzquierdo">
                <div class="titulo">
                    Paquetes
                </div>

                <b>Buscar Paquetes:</b>
                <input type="text" name="buscador" id="parametro" style="width: 100px" />
                <a type="button" id="btnBuscar"><img src="img/buscador.png"></a>
                <a id="btnListarTodos"><img src="img/volver.png"></a>


                <form method="POST" action="controladorPaquetes" id="formPaquetes">
                        <input type="hidden" name="opcion" value=""/> 
                        <input type="hidden" name="idDetalleActual" value=""/>  
                        <input type="hidden" name="id" value="">  

                    <div id="infoDerecho">
                    </div>

                    <div id="infoIzquierdo">
                        <div  id="paging_container4" class="container">
                            <h2>Paquetes</h2>
                            <div class="page_navigation"></div>
                            <ul class="content">
                                <li></li>
                                    <%
                                        if (paquetes != null) {
                                            Iterator iterador = paquetes.listIterator();
                                            // int contador = 0;
                                            while (iterador.hasNext()) {
                                                PaqueteVO paqueteVO = (PaqueteVO) iterador.next();

                                    %>

                                <li class="elemento"  onclick="cargaDetalle('controladorPaquetes',<%=paqueteVO.getIdPaquete()%>, 1, 'formPaquetes', $(this))"> 
                                    <%=paqueteVO.getNombre()%> 
                                </li>    

                                <%
                                            //contador++;
                                        } //cierra el while        

                                    }//Cierra el if  
                                %>
                        </div>
                    </div>
                </form>


                <div id="contenedorBotones">
                    <% if (rol.equals("1") || rol.equals("2") || rol.equals("3")) {
                    %>
                    <a class="fancybox" href="#inline3" title="Insertar paquete">
                        <input type="button" class="boton" value="Insertar" onclick="insertarPaquete('controladorPaquetes', 2)" />
                    </a>

                    <a class="fancybox" href="#inline3" title="Actualizar paquete">
                        <input type="button" class="boton" value="Actualizar" onclick="actualizarPaquete('controladorPaquetes', 4, 'formPaquetes')"/>
                    </a>
                    <% if (rol.equals("1") || rol.equals("2")) {
                    %>
                    <input type="button" class="boton" value="Eliminar" onclick="eliminar(6, 'formPaquetes', 'controladorPaquetes')">
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>

        <!-- Formulario para insertar -->
        <div id="inline1" class="divOculto">       
        </div>

        <!-- Formulario para actualizar -->
        <div id="inline2" class="divOculto">
        </div> 

        <div id="inline3" class="divOculto2">
        </div> 

        <div id="contenedorUsuarios" class="divOculto">
        </div>

        <div id="contenedorAyuda">
        </div>

        <div id="contenedorClave">
        </div>

        <div id="responder">
        </div>

        <script type="text/javascript">
            /* (
             function (){
             cargarLista(1,'controladorProveedores');
             }
             )();*/

            $('#btnListarTodos').on('click', function() {
                window.location.reload();
            });
            $('#btnBuscar').on('click', function() {
                var valoresBuscados = $.ajax({
                    'url': 'controladorPaquetes',
                    'type': 'POST',
                    'data': {
                        'opcion': 11,
                        'parametro': $('#parametro').val()
                    },
                    dataType: 'json',
                    async: false
                }).responseText;

                valoresBuscados = JSON.parse(valoresBuscados);
                if (valoresBuscados.length === 0) {
                    $('#infoDerecho').html("<span style=\"color:#FF0000;\"><b>No hay proveedores registrados.<b></span>");
                }

                var divLista = $('.content').html('');
                $.each(valoresBuscados, function(i, item) {

                    var div = '<li class="elemento" id="$(this).val" onClick="cargaDetalle(' + "\'controladorPaquetes\'" + ',' + item.idProducto + ', 2, ' +
                            "\'formPaquetes\'" + ',$(this))" >' +
                            item.nombre + '</li>'

                    divLista.append(div);
                });
            });
        </script>
    </body>
</html>
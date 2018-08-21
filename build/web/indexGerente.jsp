<%@page import="co.com.blummer.quotevent.modelo.vo.SolicitudVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="masterPage.jsp" />

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

<div id="contenedorIzquierdo">

    <div class="titulo">
        Solicitudes
    </div>
    <b>Buscar Solicitudes:</b>
    <input type="text" name="buscador" id="parametro" style="width: 100px" />
    <!--<input type="button" id="btnBuscar" value="buscar" />-->
    <!--<input type="button" id="btnListarTodos" value="<-" />-->
    <a type="button" id="btnBuscar"><img src="img/buscador.png"></a>
    <a id="btnListarTodos"><img src="img/volver.png"></a>

    <form method="POST" action="controladorSolicitudes" id="formSolicitudes">
        <input type="hidden" name="opcion" value=""/> 
        <input type="hidden" name="idDetalleActual" value=""/>  
        <input type="hidden" name="id" value="">

        <div id="infoDerecho">
        </div>

        <div id="infoIzquierdo">
            <div  id="paging_container4" class="container">
                <h2>Solicitudes</h2>
                <div class="page_navigation"></div>
                <ul class="content">
                    <li></li>
                        <%
                            if (solicitudes != null) {
                                Iterator iterador = solicitudes.listIterator();
                                // int contador = 0;
                                while (iterador.hasNext()) {
                                    SolicitudVO solicitudVO = (SolicitudVO) iterador.next();
                                    if (solicitudVO.getVisto() == 1) {
                        %>

                    <li class="elemento" onclick="cargaDetalle('controladorSolicitudes',<%=solicitudVO.getIdSolicitud()%>, 2, 'formSolicitudes', $(this))"><%=solicitudVO.getNombreCliente()%></li> 
                        <%
                        } else {
                        %>
                    <li class="elementoNoVisto" onclick="cargaDetalle('controladorSolicitudes',<%=solicitudVO.getIdSolicitud()%>, 2, 'formSolicitudes', $(this))"><%=solicitudVO.getNombreCliente()%></li> 
                        <%
                                    }
                                }
                            }
                        %>
                </ul>
            </div>
        </div>

    </form>

    <div id="contenedorBotones">
        <a class="fancybox" href="#inline3" title="Responder">
            <input type="button" class="boton" value="Responder" onclick="responder('controladorSolicitudes', 5)" />
        </a>

        <a class="fancybox" href="#inline1" title="Cotizar">
            <input type="button" class="boton" name="cotizar" id="btnCotizar" value="Cotizar" onclick="realizarCotizacion(7)"/>
        </a>

        <!--<input type="button" class="boton" value="Eliminar" onclick="eliminar()">-->
    </div>
</div>



<!-- Formulario para realizar cotización -->
<div id="inline1" class="divOculto">       
</div>

<!-- Formulario para Responder Solicitud  -->
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

<div id="responder" class="divOculto2">
</div>

<script type="text/javascript">
    /*function() {
     cargarLista(1, 'controladorSolicitudes');
     }*/

    $('#btnListarTodos').on('click', function () {
        window.location.reload();
    });
    $('#btnBuscar').on('click', function () {
        var valoresBuscados = $.ajax({
            'url': 'controladorSolicitudes',
            'type': 'POST',
            'data': {
                'opcion': 12,
                'parametro': $('#parametro').val()
            },
            dataType: 'json',
            async: false
        }).responseText;
        valoresBuscados = JSON.parse(valoresBuscados);
        if (valoresBuscados.length === 0) {
            $('#infoDerecho').html("<span style=\"color:#FF0000;\"><b>No hay solicitudes registradas.<b></span>");
        }

        var divLista = $('.content').html('');
        $.each(valoresBuscados, function (i, item) {

            var div = '<li class="elemento" id="$(this).val" onClick="cargaDetalle(' + "\'controladorSolicitudes\'" + ',' + item.idSolicitud + ', 2, ' +
                    "\'formSolicitudes\'" + ',$(this))" >' +
                    item.nombreCliente + '</li>'

            divLista.append(div);
        });
    });
</script>
</body>
</html>



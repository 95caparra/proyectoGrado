<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.com.blummer.quotevent.modelo.vo.SolicitudVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/estilosDescripcion.css"/>
        <meta charset="UTF-8">
        <title>Empleado</title>
    </head>
    <body>
        <!--Se obtienen los datos del empleado del request --> 
        <% SolicitudVO solicitudVO = (SolicitudVO) request.getAttribute("solicitudVO");%>

        <div id="contenedorDescripcion">
            <h1>Datos de la solicitud</h1>
            <table>
                <tr>
                    <td><b> Nombre cliente:</b></td>
                    <td>
                        <label><%=solicitudVO.getNombreCliente()%></label>
                    </td>
                </tr>

                <tr>
                    <td><b>Teléfono:</b></td>
                    <td>
                        <label><%=solicitudVO.getTelefono()%></label>
                    </td>
                </tr>
                <tr>
                    <td><b>Correo:</b></td>
                    <td>
                        <label><%=solicitudVO.getEmail()%></label>
                    </td>
                </tr> 
                <tr>
                    <td><b>Tipo evento:</b></td>
                    <td>
                        <label><%=solicitudVO.getTipoEvento().getNombreTipoEvento()%></label>
                    </td>
                </tr>
                <tr>
                    <td><b>Cantidad personas:</b></td>
                    <td>
                        <label><%=solicitudVO.getCantidadPersonas()%></label>
                    </td>
                </tr>
                <tr>
                    <td><b>Fecha:</b></td>
                    <td>
                        <label><%= new SimpleDateFormat("dd/MM/yyyy").format(solicitudVO.getFecha())%></label>
                    </td>
                </tr>
                <tr>
                    <td><b>Hora:</b></td>
                    <td>
                        <label><%=solicitudVO.getHora()%></label>
                    </td>
                </tr>
                <tr>
                    <td><b>Observaciones:</b></td>
                    <td>
                        <label><%=solicitudVO.getObservaciones()%></label>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>

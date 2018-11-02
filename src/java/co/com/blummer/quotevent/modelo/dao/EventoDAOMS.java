package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class EventoDAOMS extends ConexionMySQL implements EventoDAO {

    @Override
    public int insertar(EventoVO eventoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = " INSERT INTO evento(solicitud_id_solicitud,cliente_id_cliente,"
                    + " tipo_evento,id_lugar,cantidad_personas,cantidad_meseros,"
                    + " hora_inicio,hora_fin,fecha,precio,observaciones,estado_evento) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            int t = 1;
            pstm.setInt(t++, eventoVO.getSolicitudVO().getIdSolicitud());
            pstm.setLong(t++, eventoVO.getClienteVO().getNumeroIdentificacion());
            pstm.setInt(t++, eventoVO.getTipoEventoVO().getIdTipoEvento());
            pstm.setInt(t++, eventoVO.getLugarVO().getIdLugar());
            pstm.setInt(t++, eventoVO.getCantidadPersonas());
            pstm.setInt(t++, eventoVO.getCantidadMeseros());
            pstm.setTime(t++, eventoVO.getHoraInicio());
            pstm.setTime(t++, eventoVO.getHoraFin());
            pstm.setDate(t++, eventoVO.getFecha());
            pstm.setDouble(t++, eventoVO.getPrecio());
            pstm.setString(t++, eventoVO.getObservaciones());
            pstm.setInt(t++, eventoVO.getEstadoEvento().getIdEstadoEvento());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un error al insertar un evento."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }

    }

    @Override
    public int modificarEstado(long idEvento, int estadoE, Date fecha) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE evento SET "
                    + "estado_evento= ?, fecha = ? "
                    + "WHERE id_evento = ?  ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, estadoE);
            pstm.setDate(2, fecha);
            pstm.setLong(3, idEvento);

            resultado = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un error al actualizar un evento."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<EventoVO> listar() throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        EventoVO eventoVO;
        try {
            this.conectar();
            String colsulta = " SELECT s.id_solicitud, s.nombre_cliente, s.cantidad_personas "
                    + " as cantidadpersonassolicitud, "
                    + " p.id_paquete, p.nombre as nompaquete, cla.id_clasificacion,"
                    + " cla.nombre as clasificacion, " 
                    + " e.id_evento, e.fecha, e.hora_inicio, e.hora_fin, e.observaciones,"
                    + " ete.id_estado_evento, ete.nombre " 
                    + " FROM evento  e " 
                    + " JOIN solicitud s ON s.id_solicitud = e.solicitud_id_solicitud "
                    + " JOIN paquete p ON p.id_paquete = s.id_paquete " 
                    + " JOIN clasificacion cla	ON cla.id_clasificacion = p.clasificacion "
                    + " JOIN estado_evento ete ON ete.id_estado_evento = e.estado_evento ";
                    
            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                eventoVO = new EventoVO();

                eventoVO.getSolicitudVO().setIdSolicitud(rs.getInt(t++));
                eventoVO.getSolicitudVO().setNombreCliente(rs.getString(t++));
                eventoVO.getSolicitudVO().setCantidadPersonas(rs.getInt(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().setIdPaquete(rs.getInt(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().setNombre(rs.getString(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().getClasificacionVO().setIdClasificacion(rs.getInt(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().getClasificacionVO().setNombre(rs.getString(t++));                
                eventoVO.setIdEvento(rs.getInt(t++));
                eventoVO.setFecha(rs.getDate(t++));
                eventoVO.setHoraInicio(rs.getTime(t++));
                eventoVO.setHoraFin(rs.getTime(t++));
                eventoVO.setObservaciones(rs.getString(t++));
                eventoVO.getEstadoEvento().setIdEstadoEvento(rs.getInt(t++));
                eventoVO.getEstadoEvento().setNombre(rs.getString(t++));
                
                lista.add(eventoVO);
            }

        } catch (Exception e) {
            System.out.println("EventoDAOMS : se presento un error al listar: " + e.getMessage());
        } finally {
            this.desconectar();
            return lista;

        }
    }
    
    @Override
    public ArrayList<EventoVO> listarEventosMeses() throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        EventoVO eventoVO;
        try {
            this.conectar();
            String colsulta = " SELECT COUNT(e.id_evento) as cantidad, MONTH(e.fecha) as mes " 
                    +" FROM evento e "
                    +" group by MONTH(e.fecha) ";
                    
            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                eventoVO = new EventoVO();
                
                eventoVO.setCantidadEventos(rs.getInt(t++));
                eventoVO.setMesEventos(rs.getString(t++));
                
                lista.add(eventoVO);
            }

        } catch (Exception e) {
            System.out.println("EventoDAOMS : se presento un error al listar: " + e.getMessage());
        } finally {
            this.desconectar();
            return lista;

        }
    }
    
    @Override
    public ArrayList<EventoVO> listarEventosEstado() throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        EventoVO eventoVO;
        try {
            this.conectar();
            String colsulta = " SELECT COUNT(e.id_evento) as cantidad, ete.nombre "
                    +" FROM evento e " 
                    +" JOIN estado_evento ete ON ete.id_estado_evento = e.estado_evento "
                    +" group by ete.nombre ";
                    
            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                eventoVO = new EventoVO();
                
                eventoVO.setCantidadEventos(rs.getInt(t++));
                eventoVO.getEstadoEvento().setNombre(rs.getString(t++));
                
                lista.add(eventoVO);
            }

        } catch (Exception e) {
            System.out.println("EventoDAOMS : se presento un error al listar: " + e.getMessage());
        } finally {
            this.desconectar();
            return lista;

        }
    }
    
    
    
      @Override
    public ArrayList<EventoVO> listarEventosVivos() throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        EventoVO eventoVO;
        try {
            this.conectar();
            String colsulta = " SELECT s.id_solicitud, s.nombre_cliente, s.cantidad_personas "
                    + " as cantidadpersonassolicitud, "
                    + " p.id_paquete, p.nombre as nompaquete, cla.id_clasificacion,"
                    + " cla.nombre as clasificacion, " 
                    + " e.id_evento, e.fecha, e.hora_inicio, e.hora_fin, e.observaciones,"
                    + " ete.id_estado_evento, ete.nombre " 
                    + " FROM evento  e " 
                    + " JOIN solicitud s ON s.id_solicitud = e.solicitud_id_solicitud "
                    + " JOIN paquete p ON p.id_paquete = s.id_paquete " 
                    + " JOIN clasificacion cla	ON cla.id_clasificacion = p.clasificacion "
                    + " JOIN estado_evento ete ON ete.id_estado_evento = e.estado_evento "
                    + " WHERE e.estado_evento IN (1,2)";
                    
            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                eventoVO = new EventoVO();

                eventoVO.getSolicitudVO().setIdSolicitud(rs.getInt(t++));
                eventoVO.getSolicitudVO().setNombreCliente(rs.getString(t++));
                eventoVO.getSolicitudVO().setCantidadPersonas(rs.getInt(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().setIdPaquete(rs.getInt(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().setNombre(rs.getString(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().getClasificacionVO().setIdClasificacion(rs.getInt(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().getClasificacionVO().setNombre(rs.getString(t++));                
                eventoVO.setIdEvento(rs.getInt(t++));
                eventoVO.setFecha(rs.getDate(t++));
                eventoVO.setHoraInicio(rs.getTime(t++));
                eventoVO.setHoraFin(rs.getTime(t++));
                eventoVO.setObservaciones(rs.getString(t++));
                eventoVO.getEstadoEvento().setIdEstadoEvento(rs.getInt(t++));
                eventoVO.getEstadoEvento().setNombre(rs.getString(t++));
                
                lista.add(eventoVO);
            }

        } catch (Exception e) {
            System.out.println("EventoDAOMS : se presento un error al listar: " + e.getMessage());
        } finally {
            this.desconectar();
            return lista;

        }
    }

    @Override
    public EventoVO consultarPorId(long idEvento) throws Exception {
        EventoVO eventoVO = null;
        try {
            this.conectar();
            String colsulta = " SELECT s.id_solicitud, cl.n_identificacion, cl.nombre,cl.correo, te.nombre, lu.nombre, "
                    +" e.cantidad_personas, e.cantidad_meseros, e.hora_inicio, e.hora_fin, e.fecha, "
                    +" e.precio, e.observaciones, ete.nombre, p.id_paquete, p.foto "
                    +" FROM evento  e "
                    +" JOIN cliente cl ON cl.n_identificacion = e.cliente_id_cliente "
                    +" JOIN tipo_evento te ON te.id_tipo_evento = e.tipo_evento "
                    +" JOIN lugar lu ON lu.id_lugar = e.id_lugar "
                    +" JOIN solicitud s ON s.id_solicitud = e.solicitud_id_solicitud "
                    +" JOIN paquete p ON p.id_paquete = s.id_paquete "
                    +" JOIN clasificacion cla	ON cla.id_clasificacion = p.clasificacion "
                    +" JOIN estado_evento ete ON ete.id_estado_evento = e.estado_evento "
                    +" WHERE e.id_evento = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            pstm.setLong(1, idEvento);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                eventoVO = new EventoVO();
                int t = 1;
                
                eventoVO.getSolicitudVO().setIdSolicitud(rs.getInt(t++));
                eventoVO.getClienteVO().setNumeroIdentificacion(rs.getLong(t++));
                eventoVO.getClienteVO().setNombre(rs.getString(t++));
                eventoVO.getClienteVO().setCorreo(rs.getString(t++));
                eventoVO.getTipoEventoVO().setNombreTipoEvento(rs.getString(t++));
                eventoVO.getLugarVO().setNombre(rs.getString(t++));
                eventoVO.setCantidadPersonas(rs.getInt(t++));
                eventoVO.setCantidadMeseros(rs.getInt(t++));
                eventoVO.setHoraInicio(rs.getTime(t++));
                eventoVO.setHoraFin(rs.getTime(t++));
                eventoVO.setFecha(rs.getDate(t++));
                eventoVO.setPrecio(rs.getDouble(t++));
                eventoVO.setObservaciones(rs.getString(t++));
                eventoVO.getEstadoEvento().setNombre(rs.getString(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().setIdPaquete(rs.getInt(t++));
                eventoVO.getSolicitudVO().getPaqueteVO().setFoto(rs.getString(t++));

            }

        } catch (Exception e) {
            System.out.println("EventoDAOMS: Se presento un ERROR al consultar id_solicitud"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return eventoVO;
        }
    }

    @Override
    public ArrayList<EventoVO> listarEventosSegunE(int estado) throws Exception {
        ArrayList<EventoVO> lista = new ArrayList<EventoVO>();
        EventoVO eventoVO;
        try {
            this.conectar();
            String colsulta = "SELECT evento.id_evento, cliente.nombre, cliente.apellido, evento.tipo_evento "
                    + "FROM evento  inner join cliente  on evento.cliente_id_cliente = cliente.n_identificacion inner join estado_evento ee on evento.estado_evento = ee.id_estado_evento  "
                    + "WHERE ee.id_estado_evento = " + estado + " ";
            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                eventoVO = new EventoVO();

                eventoVO.setIdEvento(rs.getInt(1));
                eventoVO.getClienteVO().setNombre(rs.getString(2));
                eventoVO.getClienteVO().setApellido(rs.getString(3));
                eventoVO.getTipoEventoVO().setIdTipoEvento(rs.getInt(4));
                lista.add(eventoVO);
            }
        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un ERROR al consultar la tabla"
                    + " evento: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return lista;
        }
    }

    @Override
    public ArrayList<TipoEventoVO> listarTipoEvento() throws Exception {
        ArrayList<TipoEventoVO> listaTipoEvento = new ArrayList<TipoEventoVO>();
        TipoEventoVO tipoEventoVO;
        try {
            this.conectar();
            String consulta = "select id_tipo_evento, nombre from tipo_evento";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tipoEventoVO = new TipoEventoVO();
                tipoEventoVO.setIdTipoEvento(rs.getInt(1));
                tipoEventoVO.setNombreTipoEvento(rs.getString(2));
                listaTipoEvento.add(tipoEventoVO);

            }
        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un ERROR al consultar la tabla"
                    + " tipoEvento: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listaTipoEvento;
        }
    }

    @Override
    public int consultarIdDelEvento() throws Exception {
        int idEvento = -1;
        try {
            this.conectar();
            String consulta = "Select Max(id_evento) From evento ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                idEvento = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un ERROR al consultar el id del evento "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return idEvento;
        }
    }

    //Funcion para consultar la disponibilidad de cierta fecha, el entero que retorna es el número de eventos 
    //que hay en la fecha, si la fecha es 0 significa que no hay eventos
    @Override
    public int disponibilidadFecha(Date fecha) throws Exception {
        int cantEventos = 0;
        String consulta;

        try {
            this.conectar();
            consulta = "SELECT fecha FROM evento WHERE fecha = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setDate(1, fecha);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cantEventos++;
            }
        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un ERROR al consultar la disponibilidad de una fecha. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return cantEventos;
        }
    }

    @Override
    public ArrayList<EventoVO> buscar(String parametro) throws Exception {
        ArrayList<EventoVO> busca = new ArrayList<EventoVO>();
        EventoVO eventoVO = null;
        try {
            this.conectar();
            String consulta = "SELECT id_evento, c.nombre "
                    + "FROM evento e INNER JOIN cliente c ON c.n_identificacion = e.cliente_id_cliente   "
                    + "WHERE c.nombre LIKE  '%" + parametro + "%' OR lugar LIKE  '%" + parametro + "%' OR cantidad_personas LIKE  '%" + parametro + "%' OR cantidad_meseros LIKE  '%" + parametro + "%' OR precio LIKE  '%" + parametro + "%' OR observaciones LIKE  '%" + parametro + "%'        ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                eventoVO = new EventoVO();

                eventoVO.setIdEvento(rs.getInt(1));
                eventoVO.getClienteVO().setNombre(rs.getString(2));

                busca.add(eventoVO);

            }
        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un ERROR al buscar en la tabla"
                    + " producto: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return busca;
        }
    }

    @Override
    public Date validarFecha(int mes, int anio) throws Exception {
        Date fecha = null;
        try {
            this.conectar();
            String consulta = " SELECT fecha "
                    + " FROM evento "
                    + " WHERE MONTH(fecha) = ? AND YEAR(fecha) = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, mes);
            pstm.setInt(2, anio);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                fecha = rs.getDate(1);
            }

        } catch (Exception e) {
            System.out.println(" EventoDAOMS: Se presento un ERROR al buscar en la tabla"
                    + " evento: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return fecha;
        }
    }

    @Override
    public int ultimoId() throws Exception {
        int id = -1;
        try {
            this.conectar();
            String consulta = "SELECT id_evento "
                    + "FROM evento ORDER BY 1 DESC LIMIT 1 ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("EventoDAOMS: Se presento un ERROR al consultar el id del producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return id;
        }
    }

}

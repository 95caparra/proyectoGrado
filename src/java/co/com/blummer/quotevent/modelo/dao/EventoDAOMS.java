package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jhon Lagos
 */
public class EventoDAOMS extends ConexionMySQL implements EventoDAO {

    @Override
    public int insertar(EventoVO eventoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = " INSERT INTO evento(solicitud_id_solicitud,cliente_id_cliente,tipo_evento,lugar,cantidad_personas,"
                    + "cantidad_meseros,hora_inicio,hora_fin,fecha,precio,pedido_id_pedido,observaciones,estado_evento) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, eventoVO.getSolicitudVO().getIdSolicitud());
            pstm.setLong(2, eventoVO.getClienteVO().getNumeroIdentificacion());
            pstm.setInt(3, eventoVO.getTipoEventoVO().getIdTipoEvento());
            pstm.setString(4, eventoVO.getLugar());
            pstm.setInt(5, eventoVO.getCantidadPersonas());
            pstm.setInt(6, eventoVO.getCantidadMeseros());
            pstm.setTime(7, eventoVO.getHoraInicio());
            pstm.setTime(8, eventoVO.getHoraFin());
            pstm.setDate(9, eventoVO.getFecha());
            pstm.setDouble(10, eventoVO.getPrecio());
            pstm.setInt(11, 4); //El numero 4 es un pedido por defecto pero en realidad seria el id 0
            pstm.setString(12, eventoVO.getObservaciones());
            pstm.setInt(13, 1);

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
    public int modificarEstado(long idEvento, int estadoE) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE evento SET "
                    + "estado_evento= ? "
                    + "WHERE id_evento = ?  ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, estadoE);
            pstm.setLong(2, idEvento);
            
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
            String colsulta = "SELECT evento.id_evento, cliente.nombre, cliente.apellido, evento.tipo_evento "
                    + "FROM evento  inner join cliente  on evento.cliente_id_cliente = cliente.n_identificacion Order By evento.id_evento Desc ";
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
            String consulta = "SELECT evento.id_evento, evento.solicitud_id_solicitud, cliente.nombre, cliente.apellido, evento.tipo_evento,tipo_evento.nombre,evento.lugar, evento.cantidad_personas,"
                    + "evento.cantidad_meseros, evento.hora_inicio, evento.hora_fin, evento.fecha, evento.precio, evento.pedido_id_pedido, estado_evento.nombre "
                    + "FROM ((evento  inner join cliente  on evento.cliente_id_cliente = cliente.n_identificacion)inner join estado_evento ON estado_evento.id_estado_evento = evento.estado_evento) "
                    + "inner join tipo_evento ON tipo_evento.id_tipo_evento = evento.tipo_evento "
                    + "WHERE evento.id_evento = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idEvento);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                eventoVO = new EventoVO();
                eventoVO.setIdEvento(rs.getInt(1));
                eventoVO.getSolicitudVO().setIdSolicitud(rs.getInt(2));
                eventoVO.getClienteVO().setNombre(rs.getString(3));
                eventoVO.getClienteVO().setApellido(rs.getString(4));
                eventoVO.getTipoEventoVO().setIdTipoEvento(rs.getInt(5));
                eventoVO.getTipoEventoVO().setNombreTipoEvento(rs.getString(6));
                eventoVO.setLugar(rs.getString(7));
                eventoVO.setCantidadPersonas(rs.getInt(8));
                eventoVO.setCantidadMeseros(rs.getInt(9));
                eventoVO.setHoraInicio(rs.getTime(10));
                eventoVO.setHoraFin(rs.getTime(11));
                eventoVO.setFecha(rs.getDate(12));
                eventoVO.setPrecio(rs.getDouble(13));
                eventoVO.getPedidoVO().setIdPedido(rs.getInt(14));
                eventoVO.getEstadoEvento().setNombre(rs.getString(15));

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
                    +"FROM evento e INNER JOIN cliente c ON c.n_identificacion = e.cliente_id_cliente   " 
                    +"WHERE c.nombre LIKE  '%"+parametro+"%' OR lugar LIKE  '%"+parametro+"%' OR cantidad_personas LIKE  '%"+parametro+"%' OR cantidad_meseros LIKE  '%"+parametro+"%' OR precio LIKE  '%"+parametro+"%' OR observaciones LIKE  '%"+parametro+"%'        ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                eventoVO = new EventoVO();
                
                eventoVO.setIdEvento(rs.getInt(1));
                eventoVO.getClienteVO().setNombre(rs.getString(2));

                busca.add(eventoVO);

            }
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un ERROR al buscar en la tabla"
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
            System.out.println(" ProductoDAOMS: Se presento un ERROR al buscar en la tabla"
                    + " evento: " + e.getMessage());
            throw e;
        }finally{
            this.desconectar();
            return fecha;
        }
    }
    

}

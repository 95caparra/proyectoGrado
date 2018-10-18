/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jhon Lagos
 */
public class SolicitudDAOMS extends ConexionMySQL implements SolicitudDAO {

    @Override
    public int insertar(SolicitudVO solicitudVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO solicitud (nombre_cliente,cantidad_personas, "
                    + " telefono,email,id_tipo_evento, id_paquete, "
                    + " hora, fecha, observaciones, estado, visto) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int c = 1;
            
            pstm.setString(c++, solicitudVO.getNombreCliente());
            pstm.setInt(c++, solicitudVO.getCantidadPersonas());
            pstm.setString(c++, solicitudVO.getTelefono());
            pstm.setString(c++, solicitudVO.getEmail());
            pstm.setInt(c++, solicitudVO.getTipoEventoVO().getIdTipoEvento());
            pstm.setInt(c++, solicitudVO.getPaqueteVO().getIdPaquete());
            pstm.setString(c++, solicitudVO.getHora());
            pstm.setDate(c++, solicitudVO.getFecha());               
            pstm.setString(c++, solicitudVO.getObservaciones());
            pstm.setString(c++, "Activo");
            pstm.setInt(c++,solicitudVO.getVisto());
            
            resultado = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("SolicitudDAOMS: se presento un error al insertar una solicitud: " + e.getMessage());

        } finally {
            this.desconectar();
            return resultado;

        }
    }

    @Override
    public int eliminar(long idSolicitud) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE solicitud SET estado ='Inactivo' WHERE id_solicitud = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idSolicitud);
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SolicitudDAOMS: se presento un error al eliminar una solicitud: " + e.getMessage());
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
       public ArrayList<SolicitudVO> listar() throws Exception {
        ArrayList<SolicitudVO> lista = new ArrayList<SolicitudVO>();
        SolicitudVO solicitudVO = null;
        try {
            this.conectar();
            String colsulta = " SELECT sl.id_solicitud,sl.nombre_cliente,sl.cantidad_personas,sl.telefono, "
                    + " sl.email,te.id_tipo_evento,te.nombre,pq.id_paquete, pq.nombre, "
                    + " sl.hora, sl.fecha, sl.observaciones,sl.visto "
                    + " FROM solicitud sl "
                    + " join paquete pq on pq.id_paquete = sl.id_paquete  "
                    + " join tipo_evento te on te.id_tipo_evento = sl.id_tipo_evento  "
                    + " WHERE sl.estado = 'Activo' Order By id_solicitud Desc ";
            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {                
                int c = 1;                
                solicitudVO = new SolicitudVO();                
                
                solicitudVO.setIdSolicitud(rs.getInt(c++));
                solicitudVO.setNombreCliente(rs.getString(c++));
                solicitudVO.setCantidadPersonas(rs.getInt(c++));
                solicitudVO.setTelefono(rs.getString(c++));
                solicitudVO.setEmail(rs.getString(c++));
                solicitudVO.getTipoEventoVO().setIdTipoEvento(rs.getInt(c++)); 
                solicitudVO.getTipoEventoVO().setNombreTipoEvento(rs.getString(c++)); 
                solicitudVO.getPaqueteVO().setIdPaquete(rs.getInt(c++));
                solicitudVO.getPaqueteVO().setNombre(rs.getString(c++));
                solicitudVO.setHora(rs.getString(c++));
                solicitudVO.setFecha(rs.getDate(c++));               
                solicitudVO.setObservaciones(rs.getString(c++));
                solicitudVO.setVisto(rs.getByte(c++));
                
                lista.add(solicitudVO);

            }

        } catch (Exception e) {
            System.out.println("SolicitudDAOMS : se presento un error al listar: "+e.getMessage());
        } finally {
            this.desconectar();
            return lista;

        }
    }

    @Override
   public SolicitudVO consultarPorId(long idSolicitud) throws Exception {
        SolicitudVO solicitudVO = null;
        try {
            this.conectar();
             String consulta = " SELECT sl.id_solicitud,sl.nombre_cliente,"
                     +" sl.cantidad_personas,sl.telefono,  " 
                     +" sl.email,te.id_tipo_evento,te.nombre, "
                     +" pq.id_paquete, pq.nombre, pq.descripcion, pq.precio,"
                     +" pq.cantidad_personas, pq.pdf, pq.foto, "
                     +" sl.hora, sl.fecha, sl.observaciones,sl.visto  "
                     +" FROM solicitud sl  join paquete pq on pq.id_paquete = sl.id_paquete   " 
                     +" join tipo_evento te on te.id_tipo_evento = sl.id_tipo_evento   " 
                     +" where sl.id_solicitud= ?  ";
             
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idSolicitud);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int c = 1;                
                solicitudVO = new SolicitudVO();
                
                solicitudVO.setIdSolicitud(rs.getInt(c++));
                solicitudVO.setNombreCliente(rs.getString(c++));
                solicitudVO.setCantidadPersonas(rs.getInt(c++));
                solicitudVO.setTelefono(rs.getString(c++));
                solicitudVO.setEmail(rs.getString(c++));
                solicitudVO.getTipoEventoVO().setIdTipoEvento(rs.getInt(c++));
                solicitudVO.getTipoEventoVO().setNombreTipoEvento(rs.getString(c++));
                solicitudVO.getPaqueteVO().setIdPaquete(rs.getInt(c++));
                solicitudVO.getPaqueteVO().setNombre(rs.getString(c++));
                solicitudVO.getPaqueteVO().setDescripcion(rs.getString(c++));
                solicitudVO.getPaqueteVO().setPrecio(rs.getDouble(c++));
                solicitudVO.getPaqueteVO().setCantidadPersonas(rs.getInt(c++));
                solicitudVO.getPaqueteVO().setPdf(rs.getString(c++));
                solicitudVO.getPaqueteVO().setFoto(rs.getString(c++));
                solicitudVO.setHora(rs.getString(c++));
                solicitudVO.setFecha(rs.getDate(c++));
                solicitudVO.setObservaciones(rs.getString(c++));
                solicitudVO.setVisto(rs.getInt(c++));
            }

        } catch (Exception e) {
            System.out.println("SolicitudDAOMS: Se presento un ERROR al consultar id_solicitud"
                     + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return solicitudVO;
        }
    }

    @Override
    public ArrayList<SolicitudVO> buscar(String parametro) throws Exception {
        ArrayList<SolicitudVO> busca = new ArrayList<SolicitudVO>();
        SolicitudVO solicitudVO = null;
        try {
            this.conectar();
            String consulta = "SELECT id_solicitud, nombre_cliente  " 
                    +"FROM solicitud " 
                    +"WHERE nombre_cliente LIKE  '%"+parametro+"%' OR cantidad_personas LIKE  '%"+parametro+"%' OR telefono LIKE  '%"+parametro+"%' OR email LIKE  '%"+parametro+"%' OR hora LIKE  '%"+parametro+"%' OR observaciones LIKE  '%"+parametro+"%'        ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            //pstm.setString(1, parametro);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                solicitudVO = new SolicitudVO();
                
                solicitudVO.setIdSolicitud(rs.getInt(1));
                solicitudVO.setNombreCliente(rs.getString(2));

                busca.add(solicitudVO);

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
    
    
    
    public int actualizar(int idPaquete, int idSolicitud) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE solicitud SET "
                    + " paquete_id_paquete=? "                    
                    + " WHERE id_Solicitud=?";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idPaquete);
            pstm.setInt(2, idSolicitud);
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SolicitudDAOMS: se presento un error al "
                    + "actualizar un paquete despues de enviar un correo de respuesta "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }
    
    @Override
    public String nombrePdf(int idPaquete) throws Exception{
        String nombre = "";
        try {
            this.conectar();
            String consulta = "SELECT pdf"
                    + " FROM paquete WHERE id_paquete=? AND estado='Activo' ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setInt(1, idPaquete);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
               nombre =rs.getString(1);     
            }
            
        } catch (Exception e) {
            System.out.println(" SolicitudDAOMS: Se presento un ERROR al consultar la tabla"
                    + " paquete: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return nombre;
        }
    
    
    }
    
    @Override
    public int visto(int idSolicitud) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE solicitud SET "
                    + " visto = 1 "                    
                    + " WHERE id_Solicitud = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            pstm.setInt(1, idSolicitud);
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SolicitudDAOMS: se presento un error al "
                    + "actualizar el visto de la solicitud.  "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }
}

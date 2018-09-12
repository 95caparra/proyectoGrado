/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.SolicitudVO;
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
            String consulta = "INSERT INTO solicitud (nombre_cliente,cantidad_personas,telefono,email,id_tipo_evento, "
                    + "hora, fecha, observaciones, estado, visto) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            
            pstm.setString(1, solicitudVO.getNombreCliente());
            pstm.setInt(2, solicitudVO.getCantidadPersonas());
            pstm.setString(3, solicitudVO.getTelefono());
            pstm.setString(4, solicitudVO.getEmail());
            pstm.setInt(5, solicitudVO.getTipoEvento().getIdTipoEvento());
            pstm.setString(6, solicitudVO.getHora());
            pstm.setDate(7, solicitudVO.getFecha());               
            pstm.setString(8, solicitudVO.getObservaciones());
            pstm.setString(9, "Activo");
            pstm.setByte(10,solicitudVO.getVisto());
            
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
            String consulta = "UPDATE solicitud SET estado='Inactivo' WHERE idEvento=?";
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
        SolicitudVO solicitudVO;
        try {
            this.conectar();
            String colsulta = "SELECT id_solicitud,nombre_cliente,cantidad_personas,telefono, "
                    + "email,id_tipo_evento, hora, fecha, observaciones,visto FROM solicitud "
                    + "WHERE estado = 'Activo' Order By id_solicitud Desc ";
            PreparedStatement pstm = this.conection.prepareStatement(colsulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                solicitudVO = new SolicitudVO();
                solicitudVO.setIdSolicitud(rs.getInt(1));
                solicitudVO.setNombreCliente(rs.getString(2));
                solicitudVO.setCantidadPersonas(rs.getInt(3));
                solicitudVO.setTelefono(rs.getString(4));
                solicitudVO.setEmail(rs.getString(5));
                solicitudVO.getTipoEvento().setIdTipoEvento(rs.getInt(6));               
                solicitudVO.setHora(rs.getString(7));
                solicitudVO.setFecha(rs.getDate(8));               
                solicitudVO.setObservaciones(rs.getString(9));
                solicitudVO.setVisto(rs.getByte(10));
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
             String consulta = "SELECT s.id_solicitud, s.nombre_cliente, t.nombre as tipo , s.cantidad_personas, s.telefono," +
                     "s.email, s.hora, s.fecha, s.observaciones " +
                     "From solicitud s inner join tipo_evento t on s.id_tipo_evento = t.id_tipo_evento where s.id_solicitud=? and s.estado='Activo'  ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idSolicitud);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                 solicitudVO = new SolicitudVO();
                 solicitudVO.setIdSolicitud(rs.getInt(1));
                solicitudVO.setNombreCliente(rs.getString(2));
                solicitudVO.getTipoEvento().setNombreTipoEvento(rs.getString(3));
                solicitudVO.setCantidadPersonas(rs.getInt(4));
                solicitudVO.setTelefono(rs.getString(5));
                solicitudVO.setEmail(rs.getString(6));
                solicitudVO.setHora(rs.getString(7));
                solicitudVO.setFecha(rs.getDate(8));               
                solicitudVO.setObservaciones(rs.getString(9));
               
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

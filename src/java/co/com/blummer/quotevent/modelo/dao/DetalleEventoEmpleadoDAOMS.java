/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.DetalleEventoEmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.DetalleEventoEmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.DetalleEventoEmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;
import co.com.blummer.quotevent.modelo.vo.TipoProductoVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class DetalleEventoEmpleadoDAOMS extends ConexionMySQL implements DetalleEventoEmpleadoDAO {

    @Override
    public int insertarDetalleEventoEmpleado(DetalleEventoEmpleadoVO detalleEventoEmpleadoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();

            String consulta = "INSERT INTO detalle_evento_empleado  "
                    + "(id_evento,id_empleado,estado) "
                    + " VALUES (?,?,'Activo') ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, detalleEventoEmpleadoVO.getEventoVO().getIdEvento());
            pstm.setLong(2, detalleEventoEmpleadoVO.getEmpleadoVO().getIdentificacionEmpleado());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleEventoEmpleadoDAOMS: "
                    + "Se presentó un error al insertar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<DetalleEventoEmpleadoVO> listarDetalleEventoEmpleado() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarDetalleEventoEmpleado(DetalleEventoEmpleadoVO detalleEventoEmpleadoVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE detalle_evento_empleado SET "
                    + " id_empleado = ?, "
                    + " estado = ? "
                    + " WHERE id_evento = ? and id_empleado = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, detalleEventoEmpleadoVO.getEmpleadoVO().getIdentificacionEmpleado());
            pstm.setString(2, detalleEventoEmpleadoVO.getEstado());
            pstm.setLong(3, detalleEventoEmpleadoVO.getEventoVO().getIdEvento());
            pstm.setLong(4, detalleEventoEmpleadoVO.getEmpleadoVO().getIdentificacionEmpleado());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleEventoEmpleadoDAOMS: "
                    + "Se presentó un error al actualizar un detalle. "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<DetalleEventoEmpleadoVO> listarDetalleEventoEmpleadoPorId(long idEvento) throws Exception {
        ArrayList<DetalleEventoEmpleadoVO> lista = new ArrayList<DetalleEventoEmpleadoVO>();
        DetalleEventoEmpleadoVO detalleEventoEmpleadoVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append("  SELECT  " 
                    +" dee.id_detalle_evento_empleado,dee.id_evento, dee.id_empleado, dee.estado " 
                    +" FROM detalle_evento_empleado dee "
                    +" WHERE  dee.id_evento = ? ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            pstm.setLong(1, idEvento);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                detalleEventoEmpleadoVO = new DetalleEventoEmpleadoVO();
                
                detalleEventoEmpleadoVO.setIdDetalleEventoEmpleado(rs.getInt(c++));
                detalleEventoEmpleadoVO.getEventoVO().setIdEvento(rs.getInt(c++));
                detalleEventoEmpleadoVO.getEmpleadoVO().setIdentificacionEmpleado(rs.getLong(c++));
                detalleEventoEmpleadoVO.setEstado(rs.getString(c++));
                
                lista.add(detalleEventoEmpleadoVO);
            }

        } catch (Exception e) {
            System.out.println("DetalleEventoEmpleadoDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
        
        
    }

}

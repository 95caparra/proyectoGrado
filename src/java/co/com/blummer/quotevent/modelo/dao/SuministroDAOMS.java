/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.SuministroVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class SuministroDAOMS extends ConexionMySQL implements SuministroDAO {

    @Override
    public int insertarSuministro(SuministroVO suministroVO) throws Exception {
        int inserto = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO suministro "
                    + " (nombre,foto,cantidad,cantidad_minima, medida,precio_unidad,observaciones,estado)"
                    + " VALUES (?,?,?,?,?,?,?,'Activo')";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int c = 1;
            
            pstm.setString(c++, suministroVO.getNombre());
            pstm.setString(c++, suministroVO.getFoto());
            pstm.setInt(c++, suministroVO.getCantidad());
            pstm.setInt(c++, suministroVO.getCantidadMinima());
            pstm.setInt(c++, suministroVO.getMedidaProductoVO().getMedidaProducto());
            pstm.setDouble(c++, suministroVO.getPrecioUnidad());
            pstm.setString(c++, suministroVO.getObservaciones());

            inserto = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("SuministroDAOMS : se presento un error al insertar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return inserto;

    }

    @Override
    public ArrayList<SuministroVO> listarSuministros() throws Exception {
        ArrayList<SuministroVO> lista = new ArrayList<SuministroVO>();
        SuministroVO suministroVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_suministro,");
            sql.append("	nombre,");
            sql.append("	foto, ");
            sql.append("	cantidad,");
            sql.append("	cantidad_minima,");
            sql.append("	medida,");
            sql.append("	precio_unidad, ");
            sql.append("	observaciones, ");
            sql.append("	estado ");
            sql.append(" FROM   suministro order by 1 ");
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                suministroVO = new SuministroVO();

                suministroVO.setIdSuministro(rs.getInt(c++));
                suministroVO.setNombre(rs.getString(c++));
                suministroVO.setFoto(rs.getString(c++));
                suministroVO.setCantidad(rs.getInt(c++));
                suministroVO.setCantidadMinima(rs.getInt(c++));
                suministroVO.getMedidaProductoVO().setMedidaProducto(rs.getInt(c++));
                suministroVO.setPrecioUnidad(rs.getDouble(c++));
                suministroVO.setObservaciones(rs.getString(c++));
                suministroVO.setEstado(rs.getString(c++));

                lista.add(suministroVO);
            }

        } catch (Exception e) {
            System.out.println("SuministroDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();           
        }
         return lista;
    }

    @Override
    public int actualizarSuministro(SuministroVO suministroVO) throws Exception {
        int actualizo = -1;
         int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" UPDATE suministro SET ");
            sql.append("	nombre = ?, ");
            sql.append("	foto = ?, ");
            sql.append("	cantidad = ?, ");
            sql.append("	cantidad_minima = ?,");
            sql.append("	medida = ?, ");
            sql.append("	precio_unidad = ?, ");
            sql.append("	observaciones = ?, ");
            sql.append("	estado = ? ");
            sql.append(" WHERE ");
            sql.append(" id_suministro = ? ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            c = 1;
            
            pstm.setString(c++, suministroVO.getNombre());
            pstm.setString(c++, suministroVO.getFoto());
            pstm.setInt(c++, suministroVO.getCantidad());
            pstm.setInt(c++, suministroVO.getCantidadMinima());
            pstm.setInt(c++, suministroVO.getMedidaProductoVO().getMedidaProducto());
            pstm.setDouble(c++, suministroVO.getPrecioUnidad());
            pstm.setString(c++, suministroVO.getObservaciones());
            pstm.setString(c++, suministroVO.getEstado());
            pstm.setLong(c++, suministroVO.getIdSuministro());
            
            actualizo = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(" SuministroDAOMS: Se presento un error al actualizar un suministro."
                    + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return actualizo;
    }

    @Override
    public SuministroVO consultarSuministroPorId(long idSuministro) throws Exception {
        SuministroVO suministroVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append("	nombre,");
            sql.append("	foto, ");
            sql.append("	cantidad,");
            sql.append("	cantidad_minima,");
            sql.append("	medida,");
            sql.append("	precio_unidad, ");
            sql.append("	observaciones, ");
            sql.append("	estado ");
            sql.append(" FROM suministro ");
            sql.append(" WHERE ");
            sql.append(" id_suministro = ? ");
            sql.append(" order by 1 ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, idSuministro);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                suministroVO = new SuministroVO();

                suministroVO.setNombre(rs.getString(c++));
                suministroVO.setFoto(rs.getString(c++));
                suministroVO.setCantidad(rs.getInt(c++));
                suministroVO.setCantidadMinima(rs.getInt(c++));
                suministroVO.getMedidaProductoVO().setMedidaProducto(rs.getInt(c++));
                suministroVO.setPrecioUnidad(rs.getDouble(c++));
                suministroVO.setObservaciones(rs.getString(c++));
                suministroVO.setEstado(rs.getString(c++));

            }

        } catch (Exception e) {
            System.out.println("SuministroDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
         return suministroVO;
    }

}

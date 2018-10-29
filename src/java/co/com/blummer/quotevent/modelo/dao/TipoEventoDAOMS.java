/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class TipoEventoDAOMS extends ConexionMySQL implements TipoEventoDAO{

    @Override
    public int insertar(TipoEventoVO tipoEventoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO tipo_evento ( "
                    + " nombre "
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, tipoEventoVO.getNombreTipoEvento());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoEventoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<TipoEventoVO> listar() throws Exception {
        ArrayList<TipoEventoVO> lista = new ArrayList<TipoEventoVO>();
        TipoEventoVO tipoEventoVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_tipo_evento,");
            sql.append(" nombre");
            sql.append(" FROM tipo_evento order by 1 ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                tipoEventoVO = new TipoEventoVO();
                
                tipoEventoVO.setIdTipoEvento(rs.getInt(c++));
                tipoEventoVO.setNombreTipoEvento(rs.getString(c++));
                
                lista.add(tipoEventoVO);
            }

        } catch (Exception e) {
            System.out.println("TipoEventoDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();           
        }
         return lista;
    }

    @Override
    public int actualizar(TipoEventoVO tipoEventoVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE tipo_evento SET "
                    + " nombre = ? "
                    + " WHERE id_tipo_evento = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, tipoEventoVO.getNombreTipoEvento());
            
            pstm.setInt(t++, tipoEventoVO.getIdTipoEvento());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoEventoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public TipoEventoVO consultarPorId(long id) throws Exception {
        TipoEventoVO tipoEventoVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_tipo_evento,");
            sql.append(" nombre");
            sql.append(" FROM tipo_evento ");
            sql.append(" WHERE id_tipo_evento = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                tipoEventoVO = new TipoEventoVO();

                tipoEventoVO.setIdTipoEvento(rs.getInt(c++));
                tipoEventoVO.setNombreTipoEvento(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("TipoEventoDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return tipoEventoVO;
    }

    @Override
    public boolean validarExistencia(long id) throws Exception {
        boolean bandera = false;
        long idE = 0;
        try {
            this.conectar();

            String consulta = " SELECT id_tipo_evento "
                    + " FROM tipo_evento  "
                    + " WHERE id_tipo_evento = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                idE = rs.getLong(t++);
            }

            if (idE != 0) {
                bandera = true;
            } else {
                bandera = false;
            }

        } catch (Exception e) {
            System.out.println("TipoEventoDAOMS: Se presento un ERROR al listar la tabla : " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return bandera;
    }
    
    
}

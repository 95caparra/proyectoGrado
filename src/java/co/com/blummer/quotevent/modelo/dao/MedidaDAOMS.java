/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.MedidaProductoVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CAMILO
 */
public class MedidaDAOMS extends ConexionMySQL implements MedidaDAO {

    @Override
    public int insertarMedida(MedidaProductoVO medidaProductoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO medida_producto ( "
                    + " nombre "
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, medidaProductoVO.getNombreMedida());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" MedidalDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<MedidaProductoVO> listarMedidas() throws Exception {
        ArrayList<MedidaProductoVO> lista = new ArrayList<MedidaProductoVO>();
        MedidaProductoVO medidaProductoVO;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_medida,");
            sql.append(" nombre");
            sql.append(" FROM medida_producto order by 1 ");
            
            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = 1;
                medidaProductoVO = new MedidaProductoVO();

                medidaProductoVO.setMedidaProducto(rs.getInt(c++));
                medidaProductoVO.setNombreMedida(rs.getString(c++));
                
                lista.add(medidaProductoVO);
            }

        } catch (Exception e) {
            System.out.println("MedidaDAOMS : se presento un error al listar: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();           
        }
         return lista;
    }

    @Override
    public int actualizarMedida(MedidaProductoVO medidaProductoVO) throws Exception {
       int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE medida_producto SET "
                    + " nombre = ? "
                    + " WHERE id_medida = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, medidaProductoVO.getNombreMedida());
            
            pstm.setInt(t++, medidaProductoVO.getMedidaProducto());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" MedidalDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public MedidaProductoVO consultarMedidaPorId(long idMedida) throws Exception {
       MedidaProductoVO medidaProductoVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_medida,");
            sql.append(" nombre");
            sql.append(" FROM medida_producto ");
            sql.append(" WHERE id_medida = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, idMedida);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                medidaProductoVO = new MedidaProductoVO();

                medidaProductoVO.setMedidaProducto(rs.getInt(c++));
                medidaProductoVO.setNombreMedida(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("MedidalDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return medidaProductoVO;
    }

    @Override
    public boolean validarExistencia(long id) throws Exception {
        boolean bandera = false;
        long idE = 0;
        try {
            this.conectar();

            String consulta = " SELECT id_medida "
                    + " FROM medida_producto  "
                    + " WHERE id_medida = ? ";

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
            System.out.println("MedidalDAOMS: Se presento un ERROR al listar la tabla : " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return bandera;
    }
    

}

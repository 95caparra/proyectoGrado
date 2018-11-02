package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.util.Archivos;

public class ClasificacionDAOMS extends ConexionMySQL implements ClasificacionDAO {

    @Override
    public ArrayList<ClasificacionVO> listarClasificacion() throws Exception {
       ArrayList<ClasificacionVO> listarClasificacion = new ArrayList<>();
        ClasificacionVO clasificacionVO;
        try {
            this.conectar();
            
            String consulta = "SELECT id_clasificacion , nombre "
                    +" FROM clasificacion";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                clasificacionVO = new ClasificacionVO();
                
                clasificacionVO.setIdClasificacion(rs.getInt(1));
                clasificacionVO.setNombre(rs.getString(2));

                listarClasificacion.add(clasificacionVO);

            }
        } catch (Exception e) {
            System.out.println("ClasificacionDAOMS: Se presento un ERROR al listar la tabla paquete"
                    + " clasificacion: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listarClasificacion;
    }

    @Override
    public int insertar(ClasificacionVO clasificacionVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO clasificacion ( "
                    + " nombre "
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, clasificacionVO.getNombre());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ClasificacionDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(ClasificacionVO clasificacionVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE clasificacion SET "
                    + " nombre = ? "
                    + " WHERE id_clasificacion = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, clasificacionVO.getNombre());
            
            pstm.setInt(t++, clasificacionVO.getIdClasificacion());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ClasificacionDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ClasificacionVO consultarPorId(long id) throws Exception {
        ClasificacionVO clasificacionVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_clasificacion,");
            sql.append(" nombre");
            sql.append(" FROM clasificacion ");
            sql.append(" WHERE id_clasificacion = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                clasificacionVO = new ClasificacionVO();

                clasificacionVO.setIdClasificacion(rs.getInt(c++));
                clasificacionVO.setNombre(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("ClasificacionDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return clasificacionVO;
    }

    @Override
    public boolean validarExistencia(long id) throws Exception {
        boolean bandera = false;
        long idE = 0;
        try {
            this.conectar();

            String consulta = " SELECT id_clasificacion "
                    + " FROM clasificacion  "
                    + " WHERE id_clasificacion = ? ";

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
            System.out.println("ClasificacionDAOMS: Se presento un ERROR al listar la tabla : " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return bandera;
    }
    
}
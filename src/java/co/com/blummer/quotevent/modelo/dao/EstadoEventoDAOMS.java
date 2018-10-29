package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.RolVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
import co.com.blummer.quotevent.util.Archivos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class EstadoEventoDAOMS extends ConexionMySQL implements EstadoEventoDAO {

    @Override
    public ArrayList<EstadoEventoVO> listar() throws Exception {
        ArrayList<EstadoEventoVO> listar = new ArrayList<>();
        EstadoEventoVO estadoEventoVO;
        try {
            this.conectar();
            
            String consulta = "select id_estado_evento, nombre from estado_evento";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                estadoEventoVO = new EstadoEventoVO();
                
                estadoEventoVO.setIdEstadoEvento(rs.getInt(1));
                estadoEventoVO.setNombre(rs.getString(2));

                listar.add(estadoEventoVO);

            }
        } catch (Exception e) {
            System.out.println("EstadoEventoDAOMS: Se presento un ERROR al listar la tabla estado_evento"
                    + " clasificacion: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listar;
    }

    @Override
    public int insertar(EstadoEventoVO estadoEventoVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO estado_evento ( "
                    + " nombre "
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, estadoEventoVO.getNombre());
          
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EstadoEventoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(EstadoEventoVO estadoEventoVO) throws Exception {
         int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE estado_evento SET "
                    + " nombre = ? "
                    + " WHERE id_estado_evento = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, estadoEventoVO.getNombre());
            
            pstm.setInt(t++, estadoEventoVO.getIdEstadoEvento());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EstadoEventoDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public EstadoEventoVO consultarPorId(long id) throws Exception {
        EstadoEventoVO estadoEventoVO = null;
        int c = 0;
        try {
            this.conectar();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" id_estado_evento,");
            sql.append(" nombre");
            sql.append(" FROM estado_evento ");
            sql.append(" WHERE id_estado_evento = ? ");
            sql.append(" order by 1 ");

            PreparedStatement pstm = this.conection.prepareStatement(sql.toString());
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                c = 1;
                estadoEventoVO = new EstadoEventoVO();

                estadoEventoVO.setIdEstadoEvento(rs.getInt(c++));
                estadoEventoVO.setNombre(rs.getString(c++));
                
            }

        } catch (Exception e) {
            System.out.println("EstadoEventoDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return estadoEventoVO;
    }
}

package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;

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
    
}
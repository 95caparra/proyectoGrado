package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.CiudadVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;

public class CiudadDAOMS extends ConexionMySQL implements CiudadDAO {

    @Override
    public ArrayList<CiudadVO> listar() throws Exception {
       ArrayList<CiudadVO> listar = new ArrayList<>();
        CiudadVO ciudadVO;
        try {
            this.conectar();
            
            String consulta = "select id_ciudad, nombre from ciudad";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                ciudadVO = new CiudadVO();
                
                ciudadVO.setIdCiudad(rs.getInt(1));
                ciudadVO.setNombreCiudad(rs.getString(2));

                listar.add(ciudadVO);

            }
        } catch (Exception e) {
            System.out.println("CiudadDAOMS: Se presento un ERROR al listar la tabla ciudad"
                    + " clasificacion: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listar;
    }
    
}
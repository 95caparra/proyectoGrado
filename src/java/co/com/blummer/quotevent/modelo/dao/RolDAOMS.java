package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.RolVO;

public class RolDAOMS extends ConexionMySQL implements RolDAO {

    @Override
    public ArrayList<RolVO> listar() throws Exception {
       ArrayList<RolVO> listar = new ArrayList<>();
        RolVO rolVO;
        try {
            this.conectar();
            
            String consulta = "SELECT id_rol, nombre FROM rol ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                rolVO = new RolVO();
                
                rolVO.setIdRol(rs.getInt(1));
                rolVO.setNombreRolString(rs.getString(2));
                
                listar.add(rolVO);

            }
        } catch (Exception e) {
            System.out.println("RolDAOMS: Se presento un ERROR al listar la tabla rol: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listar;
    }
    
}
package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.CategoriaPaqueteVO;

public class CategoriaPaqueteDAOMS extends ConexionMySQL implements CategoriaPaqueteDAO {

    @Override
    public ArrayList<CategoriaPaqueteVO> listarCategoria() throws Exception {
       ArrayList<CategoriaPaqueteVO> listarCategoria = new ArrayList<CategoriaPaqueteVO>();
        CategoriaPaqueteVO categoriaPaqueteVO;
        try {
            this.conectar();
            
            String consulta = "SELECT id_categoria, nombre, foto "
                    +"FROM categoria "
                    + "WHERE estado = 'Activo' ";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                categoriaPaqueteVO = new CategoriaPaqueteVO();
                
                categoriaPaqueteVO.setIdCategoria(rs.getInt(1));
                categoriaPaqueteVO.setNombre(rs.getString(2));
                categoriaPaqueteVO.setFoto(rs.getString(3));

                listarCategoria.add(categoriaPaqueteVO);

            }
        } catch (Exception e) {
            System.out.println("CategoriaDAOMS: Se presento un ERROR al listar la tabla paquete"
                    + " categoria: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return listarCategoria;
        }
    }
    
}
package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.TipoDocumentoVO;

public class TipoDocumentoDAOMS extends ConexionMySQL implements TipoDocumentoDAO {

    @Override
    public ArrayList<TipoDocumentoVO> listar() throws Exception {
       ArrayList<TipoDocumentoVO> listar = new ArrayList<>();
        TipoDocumentoVO tipoDocumentoVO;
        try {
            this.conectar();
            
            String consulta = "select id_tipo_documento, descripcion_documento, "
                    + " abreviatura from tipo_documento";
            
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                tipoDocumentoVO = new TipoDocumentoVO();
                
                tipoDocumentoVO.setIdTipoDocumento(rs.getInt(1));
                tipoDocumentoVO.setNombreDocumento(rs.getString(2));
                tipoDocumentoVO.setAbreviatura(rs.getString(3));

                listar.add(tipoDocumentoVO);

            }
        } catch (Exception e) {
            System.out.println("TipoDocumentoDAOMS: Se presento un ERROR al listar la tabla tipo_documento"
                    + " clasificacion: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listar;
    }
    
}
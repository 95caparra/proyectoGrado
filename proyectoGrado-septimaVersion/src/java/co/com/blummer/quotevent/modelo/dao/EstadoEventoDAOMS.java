package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.EstadoEventoVO;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.TipoEventoVO;
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
}

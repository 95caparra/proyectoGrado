package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.LugarVO;

public class LugarDAOMS extends ConexionMySQL implements LugarDAO {

    @Override
    public ArrayList<LugarVO> listarLugar() throws Exception {
        ArrayList<LugarVO> listarLugar = new ArrayList<>();
        LugarVO lugarVO;
        try {
            this.conectar();

            String consulta = "SELECT id_lugar, nombre, "
                    + " descripcion,cantidad_persona_max,"
                    + " direccion, ubicacion, contacto, "
                    + " telefono_contacto, id_ciudad "
                    + " FROM lugar ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                lugarVO = new LugarVO();

                lugarVO.setIdLugar(rs.getInt(t++));
                lugarVO.setNombre(rs.getString(t++));
                lugarVO.setDescripcion(rs.getString(t++));
                lugarVO.setCantidadMaxPersonas(rs.getInt(t++));
                lugarVO.setDireccion(rs.getString(t++));
                lugarVO.setUbicacion(rs.getString(t++));
                lugarVO.setContacto(rs.getString(t++));
                lugarVO.setTelefonoContacto(rs.getString(t++));
                lugarVO.setIdCiudad(rs.getInt(t++));
                
                listarLugar.add(lugarVO);

            }
        } catch (Exception e) {
            System.out.println("LugarDAOMS: Se presento un ERROR al listar la tabla paquete"
                    + " lugar: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return listarLugar;
    }

}

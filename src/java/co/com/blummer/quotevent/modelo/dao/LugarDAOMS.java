package co.com.blummer.quotevent.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.util.Archivos;

public class LugarDAOMS extends ConexionMySQL implements LugarDAO {

    @Override
    public ArrayList<LugarVO> listarLugar() throws Exception {
        ArrayList<LugarVO> listarLugar = new ArrayList<>();
        LugarVO lugarVO;
        try {
            this.conectar();

            String consulta = "SELECT l.id_lugar, l.nombre, "
                    + " l.descripcion,l.cantidad_persona_max,"
                    + " l.direccion, l.ubicacion, l.contacto, "
                    + " l.telefono_contacto, l.id_ciudad, c.nombre "
                    + " FROM lugar l"
                    + " JOIN ciudad c ON c.id_ciudad = l.id_ciudad  ";

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
                lugarVO.getCiudadVO().setIdCiudad(rs.getInt(t++));
                lugarVO.getCiudadVO().setNombreCiudad(rs.getString(t++));
                
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

    @Override
    public int insertar(LugarVO lugarVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO lugar ( "
                    + " nombre, "
                    + " descripcion,cantidad_persona_max,"
                    + " direccion, ubicacion, contacto, "
                    + " telefono_contacto, id_ciudad " 
                    + " ) "
                    + " VALUES (?) ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, lugarVO.getNombre());
            pstm.setString(t++, lugarVO.getDescripcion());
            pstm.setInt(t++, lugarVO.getCantidadMaxPersonas());
            pstm.setString(t++, lugarVO.getDireccion());
            pstm.setString(t++, lugarVO.getUbicacion());
            pstm.setString(t++, lugarVO.getContacto());
            pstm.setString(t++, lugarVO.getTelefonoContacto());
            pstm.setInt(t++, lugarVO.getCiudadVO().getIdCiudad());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" RolDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(LugarVO lugarVO) throws Exception {
       int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE lugar SET "
                    + " nombre = ?, "
                    + " descripcion = ?, "
                    + " cantidad_persona_max = ?,"
                    + " direccion = ?, "
                    + " ubicacion = ?, "
                    + " contacto = ?, "
                    + " telefono_contacto = ?, "
                    + " id_ciudad  = ? " 
                    + " WHERE id_lugar = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            
            int t = 1;
            
            pstm.setString(t++, lugarVO.getNombre());
            pstm.setString(t++, lugarVO.getDescripcion());
            pstm.setInt(t++, lugarVO.getCantidadMaxPersonas());
            pstm.setString(t++, lugarVO.getDireccion());
            pstm.setString(t++, lugarVO.getUbicacion());
            pstm.setString(t++, lugarVO.getContacto());
            pstm.setString(t++, lugarVO.getTelefonoContacto());
            pstm.setInt(t++, lugarVO.getCiudadVO().getIdCiudad());
            
            pstm.setInt(t++, lugarVO.getIdLugar());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" LugarDAOMS: Se presento un error al actualizar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public LugarVO consultarPorId(long id) throws Exception {
        LugarVO lugarVO = null;
        int t = 0;
        try {
            this.conectar();
            String consulta = "SELECT id_lugar, nombre, "
                    + " descripcion,cantidad_persona_max,"
                    + " direccion, ubicacion, contacto, "
                    + " telefono_contacto, id_ciudad "
                    + " FROM lugar "
                    + " WHERE id_lugar = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta.toString());
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
                t = 1;
                lugarVO = new LugarVO();

                lugarVO.setIdLugar(rs.getInt(t++));
                lugarVO.setNombre(rs.getString(t++));
                lugarVO.setDescripcion(rs.getString(t++));
                lugarVO.setCantidadMaxPersonas(rs.getInt(t++));
                lugarVO.setDireccion(rs.getString(t++));
                lugarVO.setUbicacion(rs.getString(t++));
                lugarVO.setContacto(rs.getString(t++));
                lugarVO.setTelefonoContacto(rs.getString(t++));
                lugarVO.getCiudadVO().setIdCiudad(rs.getInt(t++));
                
            }

        } catch (Exception e) {
            System.out.println("LugarDAOMS : se presento un error al consultar por id: " + e.getMessage());
            Archivos.escribirLog("Se presnto un error " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lugarVO;
    }

    @Override
    public boolean validarExistencia(long id) throws Exception {
        boolean bandera = false;
        long idE = 0;
        try {
            this.conectar();

            String consulta = " SELECT id_lugar "
                    + " FROM lugar  "
                    + " WHERE id_lugar = ? ";

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
            System.out.println("LugarDAOMS: Se presento un ERROR al listar la tabla : " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
        return bandera;
    }

}

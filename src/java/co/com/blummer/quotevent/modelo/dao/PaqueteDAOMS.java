package co.com.blummer.quotevent.modelo.dao;

import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaqueteDAOMS extends ConexionMySQL implements PaqueteDAO {

    @Override
    public int insertar(PaqueteVO paqueteVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "INSERT INTO paquete(nombre, descripcion, foto, estado) "
                    + "VALUES(?,?,?,'Activo')";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

              pstm.setString(1, paqueteVO.getNombre());
              pstm.setString(2, paqueteVO.getDescripcion());
              pstm.setString(3, paqueteVO.getFoto());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un error al insertar "
                    + "un paquete "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int actualizar(PaqueteVO paqueteVO) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE paquete SET "
                    + "nombre = ?, "
                    + "descripcion = ?, "
                    + "foto = ? "
                    + "WHERE id_paquete = ?";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

              pstm.setString(1, paqueteVO.getNombre());
              pstm.setString(2, paqueteVO.getDescripcion());
              pstm.setString(3, paqueteVO.getFoto());
              pstm.setInt(4, paqueteVO.getIdPaquete());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un error al "
                    + "actualizar un Paquete "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public int eliminar(long idPaquete) throws Exception {
        int resultado = -1;
        try {
            this.conectar();
            String consulta = "UPDATE paquete  SET estado = 'Inactivo' "
                    + "WHERE id_paquete =? ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idPaquete);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un error al eliminar"
                    + " un Paquete "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return resultado;
        }
    }

    @Override
    public ArrayList<PaqueteVO> listar() throws Exception {
        ArrayList<PaqueteVO> lista = new ArrayList<PaqueteVO>();
        PaqueteVO paqueteVO;
        int cont = 0;
        try {
            this.conectar();
            String consulta = "SELECT pq.id_paquete, pq.nombre, pq.foto, pq.estado "
                    +" FROM paquete pq "
                    +" WHERE pq.estado = 'Activo' ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                cont=1;
                paqueteVO = new PaqueteVO();

                paqueteVO.setIdPaquete(rs.getInt(cont++));
                paqueteVO.setNombre(rs.getString(cont++));
                paqueteVO.setFoto(rs.getString(cont++));
                paqueteVO.setEstado(rs.getString(cont++));

                lista.add(paqueteVO);

            }
        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un ERROR al consultar la tabla"
                    + " paquete: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return lista;
        }
    }

    public ArrayList<PaqueteVO> listarPaqueteSegunTipo(int tipo) throws Exception {
        ArrayList<PaqueteVO> lista = new ArrayList<PaqueteVO>();
        PaqueteVO paqueteVO;
        try {
            this.conectar();
            String consulta = "SELECT p.id_paquete, p.nombre, cl.id_clasificacion, "
                    + "cl.nombre, ca.id_categoria, ca.nombre, p.lugar, p.cantidad_personas, p.precio, p.pdf, p.foto\n"
                    + "FROM (paquete p INNER JOIN clasificacion cl ON p.clasificacion = cl.id_clasificacion) "
                    + "INNER JOIN categoria ca ON p.categoria = ca.id_categoria WHERE p.categoria = " + tipo + " AND estado = 'Activo'";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                paqueteVO = new PaqueteVO();

                paqueteVO.setIdPaquete(rs.getInt(1));
                paqueteVO.setNombre(rs.getString(2));
//                paqueteVO.getClasificacionVO().setIdClasificacion(rs.getInt(3));
//                paqueteVO.getClasificacionVO().setNombre(rs.getString(4));
//                paqueteVO.getCategoriaVO().setIdCategoria(rs.getInt(5));
//                paqueteVO.getCategoriaVO().setNombre(rs.getString(6));
//                paqueteVO.setLugar(rs.getString(7));
//                paqueteVO.setCantidadPersonas(rs.getInt(8));
//                paqueteVO.setPrecio(rs.getDouble(9));
//                paqueteVO.setPdf(rs.getString(10));
//                paqueteVO.setFoto(rs.getString(11));

                lista.add(paqueteVO);

            }
        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un ERROR al consultar la tabla"
                    + " paquete: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return lista;
        }
    }

    @Override
    public PaqueteVO consultarPorId(long idPaquete) throws Exception {
        PaqueteVO paqueteVO = null;
        try {
            this.conectar();
            String consulta = "SELECT pq.id_paquete, pq.nombre, pq.descripcion, pq.foto , pq.estado " 
                    +" FROM paquete pq "
                    +" WHERE pq.id_paquete = ? ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idPaquete);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                paqueteVO = new PaqueteVO();

                paqueteVO.setIdPaquete(rs.getInt(1));
                paqueteVO.setNombre(rs.getString(2));
                paqueteVO.setDescripcion(rs.getString(3));
                paqueteVO.setFoto(rs.getString(4));
                paqueteVO.setEstado(rs.getString(5));
            }

        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un ERROR al consultar IdPaquete"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return paqueteVO;
        }
    }

    @Override
    public ArrayList<PaqueteVO> buscar(String parametro) throws Exception {
        ArrayList<PaqueteVO> busca = new ArrayList<PaqueteVO>();
        PaqueteVO paqueteVO = null;
        try {
            this.conectar();
            String consulta = "SELECT id_paquete, nombre   "
                    + "FROM paquete   "
                    + "WHERE nombre LIKE  '%" + parametro + "%'  ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                paqueteVO = new PaqueteVO();

                paqueteVO.setIdPaquete(rs.getInt(1));
                paqueteVO.setNombre(rs.getString(2));

                busca.add(paqueteVO);

            }
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un ERROR al buscar en la tabla"
                    + " producto: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return busca;
        }
    }

    @Override
    public String validarPaquete(String nombreP) throws Exception {
        String nombrePaquete = "";
        try {
            this.conectar();
            
            String consulta = "SELECT nombre "
                    + "FROM paquete "
                    + "WHERE nombre = '"+nombreP+"' ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            //pstm.setString(1, nombre);

             ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                nombrePaquete = rs.getString(1);
            }
            
        } catch (Exception e) {
            System.out.println("ProductoDAOMS: ocurrio un error al validar producto"
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return nombrePaquete;
        }
    }

    @Override
    public int ultimoId() throws Exception {
       int idPaquete = -1;
        try {
            this.conectar();
            String consulta = "SELECT id_paquete "
                    + "FROM paquete ORDER BY 1 DESC LIMIT 1 ";

            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                idPaquete = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS: Se presento un ERROR al consultar el id del producto "
                    + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return idPaquete;
        }
    }

    @Override
    public ArrayList<PaqueteVO> listarIdPaquete(int idPaquete) throws Exception {
        ArrayList<PaqueteVO> lista = new ArrayList<PaqueteVO>();
        PaqueteVO paqueteVO;
        try {
            this.conectar();
            String consulta = "SELECT pq.id_paquete, pq.nombre, pq.descripcion, pq.foto, pq.estado "
                    +" FROM paquete pq "
                    +" WHERE pq.estado = 'Activo' AND pq.id_paquete ";
            PreparedStatement pstm = this.conection.prepareStatement(consulta);            
            pstm.setInt(1, idPaquete);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                paqueteVO = new PaqueteVO();

                paqueteVO.setIdPaquete(rs.getInt(1));
                paqueteVO.setNombre(rs.getString(2));
                paqueteVO.setDescripcion(rs.getString(3));
                paqueteVO.setFoto(rs.getString(4));
                paqueteVO.setEstado(rs.getString(5));

                lista.add(paqueteVO);

            }
        } catch (Exception e) {
            System.out.println("PaqueteDAOMS: Se presento un ERROR al consultar la tabla"
                    + " paquete: " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
            return lista;
        }
    }

}

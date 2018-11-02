package co.com.blummer.quotevent.modelo.service;

import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAO;
import co.com.blummer.quotevent.modelo.dao.DetallePaqueteDAOMS;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DetallePaqueteService {

    private static DetallePaqueteDAO detallePaqueteDAO;
    private boolean bandera;

    public DetallePaqueteService() {
        this.detallePaqueteDAO = new DetallePaqueteDAOMS();
    }

    public int insertar(int idPaquete, String[] productos, String[] cantidades) throws Exception {
        int resultado = -1;
        try {
            DetallePaqueteVO detallePaquete;

            for (int i = 0; i < productos.length; i++) {

                detallePaquete = new DetallePaqueteVO();

                detallePaquete.getPaqueteVO().setIdPaquete(idPaquete);
                detallePaquete.getProductoVO().setIdProducto(Integer.parseInt(productos[i]));
                detallePaquete.setCantidad(Integer.parseInt(cantidades[i]));

                resultado += this.detallePaqueteDAO.insertar(detallePaquete);
                /*producto = Integer.parseInt(productos[i]);
                 if (bandera == false) {
                 for (int j = 0; j < productos.length; j++) {
                 ids[j] = Integer.parseInt(productos[j]);

                 producto2 = ids[j];

                 if (producto == producto2) {
                 cantidad += 1;
                 //cantidades[j] = cantidad;
                 bandera = true;
                 } else {
                 cantidad2 += 1;
                 //cantidades[j] = cantidad;
                 }
                 }
                 }
                 }

                 int[] unicos = new int[ids.length];
                 int qtd = 0;
                 for (int h = 0; h < ids.length; h++) {
                 boolean existe = false;
                 for (int j = 0; j < qtd; j++) {
                 if (unicos[j] == ids[h]) {
                 existe = true;
                 break;
                 }
                 }
                 if (!existe) {
                 unicos[qtd++] = ids[h];
                 }
                 }
                 // ajuste do tamanho do vetor resultante
                 unicos = Arrays.copyOf(unicos, qtd);

                 int[] unicos2 = new int[cantidades.length];
                 int qtd2 = 0;
                 for (int h = 0; h < cantidades.length; h++) {
                 boolean existe2 = false;
                 for (int j = 0; j < qtd; j++) {
                 //                    if (unicos2[j] == cantidades[h]) {
                 //                        existe2 = true;
                 //                        break;
                 //                    }
                 }
                 if (!existe2) {
                 //                    unicos2[qtd2++] = cantidades[h];
                 }
                 }
                 // ajuste do tamanho do vetor resultante
                 unicos2 = Arrays.copyOf(unicos2, qtd2);

                 // imprime resultado
                 int cant = unicos2.length;
                 for (int k = 0; k < unicos.length; k++) {
                 */
            }

        } catch (Exception e) {
            System.out.println(" DetallePaqueteService: "
                    + "Se presentÃ³ un error al insertar una calificaciÃ³n. "
                    + e.getMessage());
            throw e;
        } finally {
            return resultado;
        }
    }

    public int insertarA(int idPaquete, int producto, int cantidad) throws Exception {
        int resultado = -1;
        try {
            DetallePaqueteVO detallePaquete;
            detallePaquete = new DetallePaqueteVO();

            detallePaquete.getPaqueteVO().setIdPaquete(idPaquete);
            detallePaquete.getProductoVO().setIdProducto(producto);
            detallePaquete.setCantidad(cantidad);

            resultado += this.detallePaqueteDAO.insertar(detallePaquete);

        } catch (Exception e) {
            System.out.println(" DetallePaqueteService: "
                    + "Se presentÃ³ un error al insertar una calificaciÃ³n. "
                    + e.getMessage());
            throw e;
        } finally {
            return resultado;
        }
    }

    public int eliminar(int idPaquete, int idProducto) throws Exception {
        int resultado = -1;
        try {

            resultado += this.detallePaqueteDAO.eliminar(idProducto, idPaquete);

        } catch (Exception e) {
            System.out.println(" DetallePaqueteService: "
                    + "Se presentÃ³ un error al insertar una calificaciÃ³n. "
                    + e.getMessage());
            throw e;
        } finally {
            return resultado;
        }
    }

    public int eliminarTodo() throws Exception {
        int resultado = -1;
        try {

            resultado += this.detallePaqueteDAO.eliminarTodo();

        } catch (Exception e) {
            System.out.println(" DetallePaqueteService: "
                    + "Se presentÃ³ un error al insertar una calificaciÃ³n. "
                    + e.getMessage());
            throw e;
        } finally {
            return resultado;
        }
    }

    public ArrayList<DetallePaqueteVO> consultarPorId(long idPaquete) throws Exception {

        ArrayList<DetallePaqueteVO> lista = new ArrayList<DetallePaqueteVO>();
        try {
            lista = detallePaqueteDAO.consultaPorId(idPaquete);
        } catch (Exception e) {
            System.out.println("PaqueteService: Se presento un error al realizar la"
                    + "consulta: " + e.getMessage());

        } finally {
            return lista;
        }
    }

    public int actualizar(int idPaquete, String[] productos, String[] cantidades) throws Exception {
        int resultado = -1;
        int productoE = 0;
        int cantidad = 0;
        int cont = 0;
        boolean bandera = false;
        try {
            DetallePaqueteVO detallePaquete;
            ArrayList<DetallePaqueteVO> lista = detallePaqueteDAO.consultaPorId(idPaquete);
            detallePaquete = new DetallePaqueteVO();
            if (productos == null) {
                this.eliminarTodo();
            } else {
                if (lista.size() > productos.length) {
                    for (int i = 0; i <lista.size(); i++) {
                        productoE = lista.get(i).getProductoVO().getIdProducto();
                        this.eliminar(idPaquete, productoE);
                        cont++;
                    }
                    this.insertar(idPaquete, productos, cantidades);
                    /*for (int h = cont; h < productos.length; h++) {

                     detallePaquete.getPaqueteVO().setIdPaquete(idPaquete);
                     detallePaquete.getProductoVO().setIdProducto(Integer.parseInt(productos[h]));
                     detallePaquete.setCantidad(Integer.parseInt(cantidades[h]));
                        
                     productoE = lista.get(h).getProductoVO().getIdProducto();
                     resultado += this.detallePaqueteDAO.actualizar(detallePaquete,productoE);
                        
                     cont++;
                        
                     for (int q = 0; q < lista.size(); q++) {
                     //productoE = lista.get(q).getProductoVO().getIdProducto();
                     productoE = detallePaqueteDAO.consultaPorId2(idPaquete);
                     if (productoE != Integer.parseInt(productos[h])) {
                     this.eliminar(idPaquete, productoE);
                     bandera = true;
                     }                            
                     }
                     }*/

                } else {
                    for (int i = 0; i < lista.size(); i++) {

                        detallePaquete.getPaqueteVO().setIdPaquete(idPaquete);
                        detallePaquete.getProductoVO().setIdProducto(Integer.parseInt(productos[i]));
                        detallePaquete.setCantidad(Integer.parseInt(cantidades[i]));

                        productoE = lista.get(i).getProductoVO().getIdProducto();
                        resultado += this.detallePaqueteDAO.actualizar(detallePaquete, productoE);
                        cont++;
                    }
                }
                for (int j = cont; j < productos.length; j++) {

                    productoE = Integer.parseInt(productos[j]);
                    cantidad = Integer.parseInt(cantidades[j]);
                    this.insertarA(idPaquete, productoE, cantidad);
                    cont++;
                }
            }

        } catch (Exception e) {
            System.out.println(" DetallePaqueteService: "
                    + "Se presentÃ³ un error al insertar una calificaciÃ³n. "
                    + e.getMessage());
            throw e;
        } finally {
            return resultado;
        }
    }

}

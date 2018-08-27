package co.com.blummer.quotevent.controlador;

import co.com.blummer.quotevent.modelo.service.CategoriaPaqueteService;
import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.DetallePaqueteService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.service.ProductoService;
import co.com.blummer.quotevent.modelo.vo.CategoriaVO;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.ClienteVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ControladorPaquetes extends PrincipalControl {

    //objeto Service
    private PaqueteService paqueteService;

    private ClasificacionService clasificacionService;
    private CategoriaPaqueteService categoriaService;
    private ProductoService productoService;
    private DetallePaqueteVO detallePaqueteVO;
    private DetallePaqueteService detallePaqueteService;
    //objeto VO
    private PaqueteVO paqueteVO;
    private ProductoVO productoVO;
    //un entero id, se usará al actualizar y eliminar
    private long id;
    private int resultado;
    private ArrayList listaPaquetes;
    private ArrayList<CategoriaVO> listaCategorias;
    private ArrayList<ProductoVO> listaProductos;
    private ArrayList<ClasificacionVO> listaClasificacion;
    boolean bandera = false;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.request = req;
        this.response = resp;

        //se crea la sesión
        session = request.getSession(true);

        //Se inicializa el mensaje en null, para que no muestre mensajes anteriores
        session.setAttribute("mensaje", null);

        //variable que me permite saber la acción a realizar
        String opc = req.getParameter("opcion").toString();
        //la pasamos a int para usarla en el switch
        int opcion = Integer.parseInt(opc);

        this.procesaPeticion(opcion);
    }

    private void procesaPeticion(int opcion) {
        try {

            response.setContentType("application/json");
            switch (opcion) {

                case 0:
                    this.listaPaquete();
                    break;

                case 1:// Descripcion de Paquetes
                    this.descripcionPaquete();
                    break;

                case 2: // Formulrio para Insertar Paquetes
                    this.formularioInsertarPaquete();
                    break;

                case 3: // Formulario para Insertar Paquetes
                    this.insertarPaquete();
                    break;

                case 4: // Formulario para Actualizar Paquetes
                    this.formularioActualizarPaquete();
                    break;

                case 5: //  Actualizar Paquetes
                    this.actualizarPaquete();
                    break;

                case 6:// Eliminar Paquetes
                    this.eliminarPaquete();
                    break;

                case 7:
                    this.buscador();
                    break;

                case 10:
                    this.listaPaqueteJSON();
                    break;

                case 11:
                    this.descripcionPaqueteJSON();
                    break;
                    
                case 13:
                    this.listarSegun();
                    break;

                default:
                    response.setContentType("text/html; charset=UTF-8");
                    this.request.setAttribute("mensaje", "Esta opcion no ha sido implementada ");
                    this.request.setAttribute("opcion", "8");
                    vista = this.request.getRequestDispatcher("respuesta.jsp");
                    vista.forward(this.request, this.response);
                    break;
            }
            vista.forward(this.request, this.response);
        } catch (ServletException ex) {
            System.out.println("ServletException " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("IOException " + ex.getMessage());
        }
    }

    //Lista Paquetes
    public void listaPaquete() throws Exception {
        paqueteService = new PaqueteService();
        ArrayList<PaqueteVO> listaPaquete = paqueteService.listar();
        this.request.setAttribute("listaPaquetes", listaPaquete);
        vista = this.request.getRequestDispatcher("listarPaquete.jsp");
    }

    public void listaPaqueteJSON() throws Exception {
        response.getWriter().write(new Gson().toJson(new PaqueteService().listar()));
    }
    
    public void listarSegun() throws Exception {
        int tipo = Integer.parseInt(this.request.getParameter("tipo").toString());
   //     response.getWriter().write(new Gson().toJson(new ProductoService().listarSegun(tipo)));
    }

    //Descripcion Paquete
    public void descripcionPaquete() throws Exception {
        id = Long.parseLong(this.request.getParameter("id").toString());
        paqueteService = new PaqueteService();
        detallePaqueteService = new DetallePaqueteService();

        paqueteVO = paqueteService.consultarPorId(id);
        ArrayList<DetallePaqueteVO> listaProductos = detallePaqueteService.consultarPorId(id);

        double precio = 0;
        int cantidad = 0;
        double precioT = 0;

        if (listaProductos != null) {
            Iterator iterador = listaProductos.listIterator();
            while (iterador.hasNext()) {
                DetallePaqueteVO detallePaqueteVO = (DetallePaqueteVO) iterador.next();
                cantidad = detallePaqueteVO.getCantidad();
                precio = detallePaqueteVO.getProductoVO().getPrecioUnidad();
                precio *= cantidad;
                precioT += precio;
            } //cierra el while    
        }//Cierra el if

        this.request.setAttribute("paqueteVO", paqueteVO);
        this.request.setAttribute("listaProductos", listaProductos);
        this.request.setAttribute("precio", precioT);
        vista = this.request.getRequestDispatcher("descripcionPaquete.jsp");
    }

    //Descripcion Paquete
    public void descripcionPaqueteJSON() throws Exception {
        id = Long.parseLong(this.request.getParameter("id").toString());
        paqueteService = new PaqueteService();
        detallePaqueteService = new DetallePaqueteService();

        paqueteVO = paqueteService.consultarPorId(id);
        ArrayList<DetallePaqueteVO> listaProductos = detallePaqueteService.consultarPorId(id);

        double precio = 0;
        int cantidad = 0;
        double precioT = 0;

        if (listaProductos != null) {
            Iterator iterador = listaProductos.listIterator();
            while (iterador.hasNext()) {
                DetallePaqueteVO detallePaqueteVO = (DetallePaqueteVO) iterador.next();
                cantidad = detallePaqueteVO.getCantidad();
                precio = detallePaqueteVO.getProductoVO().getPrecioUnidad();
                precio *= cantidad;
                precioT += precio;
            } //cierra el while    
        }//Cierra el if

        response.getWriter().write(new Gson().toJson(listaProductos));
    }

    //formularioInsertarPaquete
    public void formularioInsertarPaquete() throws Exception {

        productoService = new ProductoService();
//        listaProductos = productoService.listarTodo();

        this.request.setAttribute("productos", listaProductos);

        vista = this.request.getRequestDispatcher("pages/paquetes/insertarPaquete.jsp");
    }

    //Formulario Actualizar Paquete
    public void formularioActualizarPaquete() throws Exception {
        id = Long.parseLong(this.request.getParameter("id").toString());
        paqueteService = new PaqueteService();
        productoService = new ProductoService();
        detallePaqueteService = new DetallePaqueteService();

        paqueteVO = paqueteService.consultarPorId(id);
        ArrayList<DetallePaqueteVO> listaProductos = detallePaqueteService.consultarPorId(id);
        ArrayList<ProductoVO> listaProductos2 = new ArrayList<ProductoVO>();

        if (listaProductos != null) {
            Iterator iterador = listaProductos.listIterator();
            while (iterador.hasNext()) {
                DetallePaqueteVO detallePaqueteVO = (DetallePaqueteVO) iterador.next();
                int cantidad = detallePaqueteVO.getCantidad();
                int idP = detallePaqueteVO.getProductoVO().getIdProducto();
                for (int i = 0; i < cantidad; i++) {
                    productoVO = productoService.consultarPorId(idP);
                    listaProductos2.add(productoVO);
                }
            }
        }

        this.request.setAttribute("paqueteVO", paqueteVO);
        this.request.setAttribute("listaProductos", listaProductos);

        vista = this.request.getRequestDispatcher("actualizarPaquete.jsp");
    }

    //Insertar Proveedor
    public void insertarPaquete() throws Exception {
        //if (this.validarProveedor() == false) {

        paqueteVO = new PaqueteVO();
        paqueteService = new PaqueteService();

        detallePaqueteVO = new DetallePaqueteVO();
        detallePaqueteService = new DetallePaqueteService();

        String[] productos = this.request.getParameterValues("productos[]");
        String[] cantidades = this.request.getParameterValues("cantidades[]");
        //llamamos al método insertar 
        //if (paqueteService.insertar(paqueteVO) > 0) {
        //idProveedor = paqueteService.consultarIdProveedor();
        int idPaquete = paqueteService.ultimoIdPaquete();
        if (idPaquete == 0) {
            idPaquete += 1;
        }
        if (detallePaqueteService.insertar(idPaquete, productos, cantidades) >= 0) {
            //  id = paqueteService.consultarIdProveedor();
            //  response.getWriter().write(new Gson().toJson("Proveedor " + paqueteVO.getRazonSocial() + "ha sido ingresado con éxito. "));
        } else {
            // response.getWriter().write(new Gson().toJson("Error al insertar proveedor" + paqueteVO.getRazonSocial()));
        }
        //} else {


        // response.getWriter().write(new Gson().toJson("Error al insertar proveedor" + paqueteVO.getRazonSocial()));
        //}

        //}
    }

    public void actualizarPaquete() throws Exception {
        paqueteVO = new PaqueteVO();
        paqueteService = new PaqueteService();

        detallePaqueteVO = new DetallePaqueteVO();
        detallePaqueteService = new DetallePaqueteService();

        String[] productos = this.request.getParameterValues("productos[]");
        String[] cantidades = this.request.getParameterValues("cantidades[]");
        //llamamos al método insertar 
        //if (paqueteService.insertar(paqueteVO) > 0) {
        //idProveedor = paqueteService.consultarIdProveedor();
        int idPaquete = Integer.parseInt(this.request.getParameter("idPaquete"));

        if (detallePaqueteService.actualizar(idPaquete, productos, cantidades) >= 0) {

        } else {

        }
    }

    public void eliminarPaquete() throws Exception {
        id = Long.parseLong(this.request.getParameter("id").toString());

        //if (bandera == false) {
        paqueteService = new PaqueteService();
        if (paqueteService.eliminar(id) > 0) {
            // response.getWriter().write(new Gson().toJson("Paquete eliminado con éxito. "));
            session.setAttribute("mensaje", "Paquete  <b>" + id + "</b>  ha sido eliminado con éxito ");
        } else {
            //  session.setAttribute("mensaje", "Se presento un error, porfavor cantacte al Administrador ");
        }

        //bandera = true;
        //   this.listaPaquete();
        //}
    }

    public void buscador() throws Exception {
        response.setContentType("application/json");
        paqueteService = new PaqueteService();
        String parametro = this.request.getParameter("parametro").toString().trim();
        ArrayList<PaqueteVO> listaPaqueteBuscado = paqueteService.buscar(parametro);
        response.getWriter().write(new Gson().toJson(listaPaqueteBuscado));
    }

}

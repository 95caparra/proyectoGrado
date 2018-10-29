/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.blummer.quotevent.util;

import co.com.blummer.quotevent.modelo.vo.DetalleEventoEmpleadoVO;
import co.com.blummer.quotevent.modelo.vo.DetallePaqueteProductoVO;
import co.com.blummer.quotevent.modelo.vo.EventoVO;
import co.com.blummer.quotevent.modelo.vo.ProductoVO;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import java.util.ArrayList;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.*;

/**
 *
 * @author CAMILO
 */
public class GenerarPDF {

    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    private static final String iTextExampleImage = "/home/xules/codigoxules/iText-Example-image.png";

    /**
     * We create a PDF document with iText using different elements to learn to
     * use this library. Creamos un documento PDF con iText usando diferentes
     * elementos para aprender a usar esta librería.
     *
     * @param header
     * @param eventoVO
     * @param productos
     * @param footer
     * @param pdfNewFile  <code>String</code> pdf File we are going to write.
     * Fichero pdf en el que vamos a escribir.
     */
    public void createPDF(String header, EventoVO eventoVO, ArrayList<ProductoVO> productos, String footer,
            String rutaImagen, String salida) throws DocumentException, BadElementException, IOException {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document(PageSize.A4, 36, 36, 10, 10);

            PdfWriter.getInstance(document, new FileOutputStream(salida));

            document.open();

            document.add(getHeader(header));

            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(400, 400);
            imagen.setAlignment(Element.ALIGN_CENTER);

            document.add(imagen);
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Nombre Cliente:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getClienteVO().getNombre()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Identificación Cliente:"));
            document.add(getInfo(" "));
            document.add(getInfo(Long.toString(eventoVO.getClienteVO().getNumeroIdentificacion())));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Tipo Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getTipoEventoVO().getNombreTipoEvento()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Lugar Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getLugarVO().getNombre()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Cantidad de Personas:"));
            document.add(getInfo(" "));
            document.add(getInfo(Integer.toString(eventoVO.getCantidadPersonas())));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Cantidad de Meseros:"));
            document.add(getInfo(" "));
            document.add(getInfo(Integer.toString(eventoVO.getCantidadMeseros())));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Hora Inicio de Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getHoraInicio().toString()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Hora Fin de Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getHoraFin().toString()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Fecha de Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getFecha().toString()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Precio de Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(Double.toString(eventoVO.getPrecio())));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Observaciones de Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getObservaciones()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            document.add(getInfo("Estado de Evento:"));
            document.add(getInfo(" "));
            document.add(getInfo(eventoVO.getEstadoEvento().getNombre()));
            document.add(getInfo(" "));
            document.add(getInfo(" "));
            
            String ruta = Path.getPathArchivos() + "\\" + "imagenesProductos" + "\\";
            for (ProductoVO p : productos) {
                String rutaImagenProducto = ruta.concat(p.getFoto());
                Image imagen2 = Image.getInstance(rutaImagenProducto);
                imagen2.scaleAbsolute(250, 250);
                imagen2.setAlignment(Element.ALIGN_LEFT);
            }

            document.add(getFooter(footer));

            document.close();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("No such file was found to generate the PDF "
                    + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
        }

        System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");

    }

    private Paragraph getHeader(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(chapterFont);
        p.add(c);
        return p;
    }

    private Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        p.setAlignment(Element.ALIGN_LEFT);

        Chunk c = new Chunk();
        c.append(texto);
        c.setFont(chapterFont);
        p.add(c);
        return p;
    }

    private Paragraph getFooter(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(chapterFont);
        p.add(c);
        return p;
    }
}

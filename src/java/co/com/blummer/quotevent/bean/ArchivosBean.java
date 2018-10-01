package co.com.blummer.quotevent.bean;

import co.com.blummer.quotevent.modelo.service.ClasificacionService;
import co.com.blummer.quotevent.modelo.service.LugarService;
import co.com.blummer.quotevent.modelo.service.PaqueteService;
import co.com.blummer.quotevent.modelo.vo.ClasificacionVO;
import co.com.blummer.quotevent.modelo.vo.LugarVO;
import co.com.blummer.quotevent.modelo.vo.PaqueteVO;
import co.com.blummer.quotevent.util.Path;
import static groovy.xml.Entity.reg;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "archivoBean")
@RequestScoped
public class ArchivosBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private UploadedFile pdf;
    private UploadedFile foto;
    private PaqueteBean paqueteBean;
    private SuministroBean suministroBean;
    private ProductoBean productoBean;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            paqueteBean = application.evaluateExpressionGet(context, "#{paqueteBean}", PaqueteBean.class);
            suministroBean = application.evaluateExpressionGet(context, "#{suministroBean}", SuministroBean.class);
            productoBean = application.evaluateExpressionGet(context, "#{productoBean}", ProductoBean.class);
            try {

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void fileUploadListenerFoto(FileUploadEvent e) throws IOException {
        foto = e.getFile();
        paqueteBean.setNombreFoto(e.getFile().getFileName());
        suministroBean.setNombreFoto(e.getFile().getFileName());
        productoBean.setNombreFoto(e.getFile().getFileName());
        
        Path.copyFileImagenes(e.getFile().getFileName(), getFoto().getInputstream());
    }

    public void fileUploadListenerPdf(FileUploadEvent e) throws IOException {
        pdf = e.getFile();
        paqueteBean.setNombrePdf(e.getFile().getFileName());
        Path.copyFile(e.getFile().getFileName(), getPdf().getInputstream());
    }

    /**
     * @return the pdf
     */
    public UploadedFile getPdf() {
        return pdf;
    }

    /**
     * @param pdf the pdf to set
     */
    public void setPdf(UploadedFile pdf) {
        this.pdf = pdf;
    }

    /**
     * @return the foto
     */
    public UploadedFile getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public PaqueteBean getPaqueteBean() {
        return paqueteBean;
    }

    public void setPaqueteBean(PaqueteBean paqueteBean) {
        this.paqueteBean = paqueteBean;
    }

    /**
     * @return the suministroBean
     */
    public SuministroBean getSuministroBean() {
        return suministroBean;
    }

    /**
     * @param suministroBean the suministroBean to set
     */
    public void setSuministroBean(SuministroBean suministroBean) {
        this.suministroBean = suministroBean;
    }

}

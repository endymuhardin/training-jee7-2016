package com.brainmatics.aplikasi.pendaftaran.view;
 
import com.brainmatics.aplikasi.pendaftaran.entity.Sekolah;
import com.brainmatics.aplikasi.pendaftaran.sessionbeans.SekolahFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "sekolahView")
@RequestScoped
public class SekolahView {

    @EJB
    private SekolahFacade sekolahFacade;
    private Sekolah sekolah = new Sekolah();
    
    public SekolahView() {
    }

    public Sekolah getSekolah() {
        return sekolah;
    }

    public void setSekolah(Sekolah sekolah) {
        this.sekolah = sekolah;
    }
    
    
    
    public List<Sekolah> getDaftarSekolah(){
        return sekolahFacade.findAll();
    } 
    
    public String editSekolah(Sekolah s){
        System.out.println("Mengedit sekolah "+s.getNama());
        return "form?faces-redirect=true&id="+s.getId();
    }
    
    public String simpan(){
        sekolahFacade.create(sekolah);
        sekolah = new Sekolah();
        return "list?faces-redirect=true";
    }
}

package com.brainmatics.aplikasi.pendaftaran.view;
 
import com.brainmatics.aplikasi.pendaftaran.entity.Sekolah;
import com.brainmatics.aplikasi.pendaftaran.sessionbeans.SekolahFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "sekolahView")
@SessionScoped
public class SekolahView implements Serializable {

    @EJB
    private SekolahFacade sekolahFacade;
    private Sekolah sekolah;
    
    public SekolahView() {
    }

    public Sekolah getSekolah() {
        if(sekolah == null){
            sekolah = new Sekolah();
        }
        return sekolah;
    }

    public void setSekolah(Sekolah sekolah) {
        this.sekolah = sekolah;
    }
    
    public List<Sekolah> getDaftarSekolah(){
        return sekolahFacade.findAll();
    } 
    
    public String editSekolah(Sekolah s){
        sekolah = s;
        System.out.println("ID Sekolah "+s.getId());
        System.out.println("Mengedit sekolah "+s.getNama());
        return "form?faces-redirect=true";
    }
    
    public String simpan(){
        if(sekolah.getId() == null){
            sekolahFacade.create(sekolah);
        } else {
            sekolahFacade.edit(sekolah);
        }
        sekolah = new Sekolah();
        return "list?faces-redirect=true";
    }
}

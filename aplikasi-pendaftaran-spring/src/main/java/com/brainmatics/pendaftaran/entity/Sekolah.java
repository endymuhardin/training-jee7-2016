package com.brainmatics.pendaftaran.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity @Table(name = "sekolah")
public class Sekolah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @NotNull @NotEmpty @Size(min = 3, max = 10)
    @Column(unique = true)
    private String kode;
    
    @NotNull @NotEmpty
    private String nama;
    private String alamat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sekolah)) {
            return false;
        }
        Sekolah other = (Sekolah) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.brainmatics.aplikasi.pendaftaran.entity.Sekolah[ id=" + id + " ]";
    }
    
}

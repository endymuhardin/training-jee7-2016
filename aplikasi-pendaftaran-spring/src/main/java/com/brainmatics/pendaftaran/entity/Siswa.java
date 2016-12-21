package com.brainmatics.pendaftaran.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name = "siswa")
public class Siswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @NotNull @NotEmpty
    private String nama;
    
    @NotNull @NotEmpty @Email
    @Column(unique = true)
    private String email;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull @Past
    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_sekolah_asal")
    private Sekolah asalSekolah;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sekolah getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(Sekolah asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
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
        if (!(object instanceof Siswa)) {
            return false;
        }
        Siswa other = (Siswa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.brainmatics.aplikasi.pendaftaran.entity.Siswa[ id=" + id + " ]";
    }
    
}

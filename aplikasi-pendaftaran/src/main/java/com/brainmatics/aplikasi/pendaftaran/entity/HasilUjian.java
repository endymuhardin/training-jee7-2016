package com.brainmatics.aplikasi.pendaftaran.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "hasil_ujian")
public class HasilUjian {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_siswa")
    private Siswa siswa;
    
    @NotNull
    @Column(name = "tanggal_ujian")
    @Temporal(TemporalType.DATE)
    private Date tanggalUjian;
    
    @ManyToOne
    @JoinColumn(name = "id_soal")
    private Soal soalYangDigunakan;
    private BigDecimal nilai;
    private Boolean lulus;
}

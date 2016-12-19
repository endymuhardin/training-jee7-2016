package com.brainmatics.aplikasi.pendaftaran.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "pilihan")
public class Pilihan {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pertanyaan")
    private Pertanyaan pertanyaan;
    private String isi;
}

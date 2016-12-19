package com.brainmatics.aplikasi.pendaftaran.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pilihan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pertanyaan")
    private Pertanyaan pertanyaan;
    private String isi;
}

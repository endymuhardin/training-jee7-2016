package com.brainmatics.aplikasi.pendaftaran.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pertanyaan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String isi;
    private String jawaban;
    
    @OneToMany(mappedBy = "pertanyaan")
    private List<Pilihan> daftarPilihan = new ArrayList<>();
}

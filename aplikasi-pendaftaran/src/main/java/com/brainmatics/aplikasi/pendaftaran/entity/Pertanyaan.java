package com.brainmatics.aplikasi.pendaftaran.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "pertanyaan")
public class Pertanyaan {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String isi;
    private String jawaban;
    
    @OneToMany(mappedBy = "pertanyaan")
    private List<Pilihan> daftarPilihan = new ArrayList<>();
}

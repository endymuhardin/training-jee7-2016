package com.brainmatics.aplikasi.pendaftaran.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Soal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull @NotEmpty
    @Column(unique = true)
    private String kode;
    
    @ManyToMany
    @JoinTable(
            name = "paket_soal_pertanyaan",
            joinColumns = @JoinColumn(name = "id_soal"),
            inverseJoinColumns = @JoinColumn(name = "id_pertanyaan")
    )
    private List<Pertanyaan> daftarPertanyaan = new ArrayList<>();
    
}

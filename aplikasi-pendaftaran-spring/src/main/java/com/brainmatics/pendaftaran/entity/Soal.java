package com.brainmatics.pendaftaran.entity;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity @Table(name = "soal")
public class Soal {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
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

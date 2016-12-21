package com.brainmatics.pendaftaran.dao;

import com.brainmatics.pendaftaran.entity.Siswa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SiswaDao extends PagingAndSortingRepository<Siswa, String>{
    
}

package com.brainmatics.pendaftaran.dao;

import com.brainmatics.pendaftaran.entity.Sekolah;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SekolahDao extends PagingAndSortingRepository<Sekolah, String>{
    
}

package com.brainmatics.pendaftaran.controller;

import com.brainmatics.pendaftaran.dao.SekolahDao;
import com.brainmatics.pendaftaran.dao.SiswaDao;
import com.brainmatics.pendaftaran.entity.Sekolah;
import com.brainmatics.pendaftaran.entity.Siswa;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SiswaController {
    @Autowired private SiswaDao siswaDao;
    @Autowired private SekolahDao sekolahDao;
    
    @ModelAttribute("daftarSekolah")
    public Iterable<Sekolah> dataSekolah(){
        return sekolahDao.findAll();
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/siswa/form", method = RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required = false, value = "id")Siswa s){
        if(s == null){
            s = new Siswa();
        }
        
        return new ModelMap(s);
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/siswa/form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Siswa s, BindingResult errors, @RequestParam("foto") MultipartFile file){
        if(errors.hasErrors()){
            return "/siswa/form";
        }
        
        prosesFoto(file);
        
        siswaDao.save(s);
        return "redirect:list";
    }
    
    private void prosesFoto(MultipartFile file){
        // tampilkan informasi tentang file
        System.out.println("Ukuran file : "+file.getSize());
        System.out.println("Tipe file : " +file.getContentType());
        System.out.println("Nama file : "+file.getOriginalFilename());
        
        // pindahkan ke tempat yang lebih sesuai
        // misalnya : file server, Amazon S3, Dropbox, CDN, dsb
    }
}

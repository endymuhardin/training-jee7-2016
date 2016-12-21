package com.brainmatics.pendaftaran.controller;

import com.brainmatics.pendaftaran.dao.SekolahDao;
import com.brainmatics.pendaftaran.dao.SiswaDao;
import com.brainmatics.pendaftaran.entity.Sekolah;
import com.brainmatics.pendaftaran.entity.Siswa;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiswaController {
    @Autowired private SiswaDao siswaDao;
    @Autowired private SekolahDao sekolahDao;
    
    @ModelAttribute("daftarSekolah")
    public Iterable<Sekolah> dataSekolah(){
        return sekolahDao.findAll();
    }
    
    @RequestMapping(value = "/siswa/form", method = RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required = false, value = "id")Siswa s){
        if(s == null){
            s = new Siswa();
        }
        
        return new ModelMap(s);
    }
    
    @RequestMapping(value = "/siswa/form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Siswa s, BindingResult errors){
        if(errors.hasErrors()){
            return "/siswa/form";
        }
        siswaDao.save(s);
        return "redirect:list";
    }
}

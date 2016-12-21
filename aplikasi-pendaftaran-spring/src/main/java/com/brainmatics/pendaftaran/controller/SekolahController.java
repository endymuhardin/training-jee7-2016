package com.brainmatics.pendaftaran.controller;

import com.brainmatics.pendaftaran.dao.SekolahDao;
import com.brainmatics.pendaftaran.entity.Sekolah;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SekolahController {
    @Autowired private SekolahDao sekolahDao;
    
    @RequestMapping("/api/sekolah/")
    @ResponseBody
    public Page<Sekolah> dataSekolahJson(Pageable page){
        return sekolahDao.findAll(page);
    }
    
    @RequestMapping("/sekolah/list")
    public ModelMap dataSekolahHtml(Pageable page){
        return new ModelMap("daftarSekolah", sekolahDao.findAll(page));
    }
    
    @RequestMapping(value = "/sekolah/form", method = RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required = false, name = "id") Sekolah sekolah ){
        if(sekolah == null){
            sekolah = new Sekolah();
        }
        return new ModelMap(sekolah);
    }
    
    @RequestMapping(value = "/sekolah/form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Sekolah s, BindingResult errors){
        if(errors.hasErrors()){
            return "/sekolah/form";
        }
        sekolahDao.save(s);
        return "redirect:list";
    }
}

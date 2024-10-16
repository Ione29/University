package com.sdm_ione.controllers;

import com.sdm_ione.domain.ClinicalFile;
import com.sdm_ione.services.ClinicalFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/clinicalfiles")
public class ClinicalFileController {
    private final ClinicalFileService clinicalFileService;

    public ClinicalFileController(ClinicalFileService clinicalFileService) {
        this.clinicalFileService = clinicalFileService;
    }

    @GetMapping
    public String viewClinicalFiles(Model model){
        model.addAttribute("clinicalfiles", clinicalFileService.findAll());
        return "clinicalfiles";
    }

    @GetMapping("/new")
    public String showAddClinicalFileForm(Model model){
        model.addAttribute("clinicalfile",new ClinicalFile());
        return "addclinicalfiles";
    }

    @PostMapping("/new")
    public String addClinicalFiles(ClinicalFile clinicalFile){
        if(clinicalFile.getId()==null)
            clinicalFile.setId(new Random().nextLong());
        clinicalFileService.save(clinicalFile);
        return "redirect:/clinicalfiles";
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("clinicalfiles", clinicalFileService.findAll());
        return "searchclinicalfiles";
    }

    @PostMapping("/search")
    public String searchClinicalFiles(@RequestParam(required = false) Long owner, @RequestParam(required = false) String diagnostic, Model model) {
        List<ClinicalFile> files = clinicalFileService.searchClinicalFiles(owner, diagnostic);
        model.addAttribute("clinicalfiles", files);
        return "searchclinicalfiles";
    }

}

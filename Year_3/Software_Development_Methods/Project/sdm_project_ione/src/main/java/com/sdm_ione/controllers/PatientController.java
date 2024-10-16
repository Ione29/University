package com.sdm_ione.controllers;

import com.sdm_ione.domain.Patient;
import com.sdm_ione.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String viewProducts(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "patients";
    }

    @GetMapping("/register")
    public String showAddProductForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "addpatients";
    }

    @PostMapping("/register")
    public String addProduct(Patient patient) {
        if (patient.getId() == null)
            patient.setId(new Random().nextLong());
        patientService.save(patient);
        return "redirect:/patients";
    }

}

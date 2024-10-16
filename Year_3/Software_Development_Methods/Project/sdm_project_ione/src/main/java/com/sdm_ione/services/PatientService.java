package com.sdm_ione.services;

import com.sdm_ione.domain.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient save(Patient p);
}

package com.sdm_ione.services;

import com.sdm_ione.domain.ClinicalFile;

import java.util.List;

public interface ClinicalFileService {
    List<ClinicalFile> findAll();
    void save(ClinicalFile cf);
    List<ClinicalFile> searchClinicalFiles(Long owner, String diagnostic);
}

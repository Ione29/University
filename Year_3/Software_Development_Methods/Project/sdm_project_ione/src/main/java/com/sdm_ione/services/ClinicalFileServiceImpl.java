package com.sdm_ione.services;

import com.sdm_ione.domain.ClinicalFile;
import com.sdm_ione.repositories.ClinicalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClinicalFileServiceImpl implements ClinicalFileService {

    private final ClinicalFileRepository clinicalFileRepository;

    @Autowired
    public ClinicalFileServiceImpl(ClinicalFileRepository clinicalFileRepository){
        this.clinicalFileRepository = clinicalFileRepository;
    }

    @Override
    public List<ClinicalFile> findAll() {
        return (List<ClinicalFile>) clinicalFileRepository.findAll();
    }

    @Override
    public void save(ClinicalFile product) {
        clinicalFileRepository.save(product);
    }

    @Override
    public List<ClinicalFile> searchClinicalFiles(Long owner, String diagnostic) {
        //if the diagnostic box is empty in the page, the query is FOR AN EMPTY STRING SO WE HAVE TO CONVERT IT AUTOMATICALLY TO NULL
        //stupid behaviour imo but I can see why it's like this
        //still infuriating
        if(diagnostic != null && diagnostic.isEmpty()){
            diagnostic = null;
        }

        //queries if everything is alright
        if (diagnostic != null && owner != null) {
            return clinicalFileRepository.findByOwnerAndDiagnostic(owner, diagnostic);
        } else if (diagnostic != null) {
            return clinicalFileRepository.findByDiagnostic(diagnostic);
        } else if (owner != null) {
            return clinicalFileRepository.findByOwner(owner);
        } else {
            return findAll();
        }
    }
}
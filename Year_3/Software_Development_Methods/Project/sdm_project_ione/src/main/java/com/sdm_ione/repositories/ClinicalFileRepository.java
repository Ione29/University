package com.sdm_ione.repositories;

import com.sdm_ione.domain.ClinicalFile;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ClinicalFileRepository extends CrudRepository<ClinicalFile, Long> {
    List<ClinicalFile> findByOwner(Long owner);
    List<ClinicalFile> findByDiagnostic(String diagnostic);
    List<ClinicalFile> findByOwnerAndDiagnostic(Long owner, String diagnostic);
}

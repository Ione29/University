package com.sdm_ione.repositories;

import com.sdm_ione.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findByEmail(String email);
    Patient findByName(String name);
}

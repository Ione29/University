package com.sdm_ione.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "clinicalfiles")
public class ClinicalFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "owner")
    private Long owner;

    @Column(nullable = false, length = 50, name = "diagnostic")
    private String diagnostic;

    public ClinicalFile(){}

    public ClinicalFile(Long id, Long owner, String diagnostic){
        this.id = id;
        this.owner = owner;
        this.diagnostic = diagnostic;
    }

    public Long getId() {
        return id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public Long getOwner() {
        return owner;
    }

    public void setDiagnostic(String category) {
        this.diagnostic = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }
}

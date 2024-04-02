package com.hw_01_sdm.CreditCard;

import java.util.Objects;

public class CreditCard {
    private Integer id, owner_id;
    private String IBAN;
    private double amount;
    
    public CreditCard(){}

    public CreditCard(String vIBAN, double vAmount){
        this.id = null;
        this.IBAN = vIBAN;
        this.amount = vAmount;
        this.owner_id = null;
    }

    public CreditCard(String vIBAN, double vAmount, int vOwner_id){
        this.id = null;
        this.IBAN = vIBAN;
        this.amount = vAmount;
        this.owner_id = vOwner_id;
    }

    public CreditCard(int vId, String vIBAN, double vAmount, int vOwner_id){
        this.id = vId;
        this.IBAN = vIBAN;
        this.amount = vAmount;
        this.owner_id = vOwner_id;
    }

    public int getId(){
        return this.id;
    }

    public String getIBAN(){
        return this.IBAN;
    }

    public double getAmount(){
        return this.amount;
    }

    public int getOwner_id(){
        return this.owner_id;
    }

    public void setId(int vId){
        this.id = vId;
    }  

    public void setAmount(int vAmount){
        this.amount = vAmount;
    }
    
    public void setOwner_Id(int vOwner_id){
        this.owner_id = vOwner_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.IBAN, this.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard creditCard = (CreditCard) o;
        return this.id == creditCard.id && Objects.equals(this.IBAN, creditCard.IBAN) && Objects.equals(this.amount, creditCard.amount);
    }

    @Override
    public String toString() {
        return "Credit Card:{" +
                "id=" + this.id +
                " | IBAN='" + this.IBAN + '\'' +
                " | amount='" + this.amount + '\'' +
                '}';
    }
}

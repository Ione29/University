package com.hw_01_sdm.CreditCard;

import java.util.Set;

public interface CreditCardDAO {
    Set<CreditCard> findAll();
    Set<CreditCard> findByIBAN(String IBAN);
    Set<CreditCard> findByOwner(int owner_id);
    CreditCard insert(CreditCard creditCard);
    void update(CreditCard creditCard);
    void delete(int creditID);
}

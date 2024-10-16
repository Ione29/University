package org.example.graphql.services;

import jakarta.transaction.Transactional;
import org.example.graphql.domain.Buyer;
import org.example.graphql.repositories.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository BuyerRepository) {
        this.buyerRepository = BuyerRepository;
    }

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Optional<Buyer> getBuyerById(Long id) {
        return buyerRepository.findById(id);
    }

    @Transactional
    public Buyer saveBuyer(Buyer Buyer) {
        return buyerRepository.save(Buyer);
    }

    @Transactional
    public void deleteBuyer(Long id) {
       buyerRepository.deleteById(id);
    }
}
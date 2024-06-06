package com.cloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.model.BitcoinPrice;

@Repository
public interface BitcoinPriceRepository extends MongoRepository<BitcoinPrice, String> {
    @SuppressWarnings("unchecked")
    public BitcoinPrice save(BitcoinPrice btcPrice);
}
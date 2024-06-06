package com.cloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.model.EthereumPrice;

@Repository
public interface EthereumPriceRepository extends MongoRepository<EthereumPrice, String> {
    @SuppressWarnings("unchecked")
    public EthereumPrice save(EthereumPrice ethPrice);
}
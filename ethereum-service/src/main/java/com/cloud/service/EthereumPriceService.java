package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.model.EthereumPrice;
import com.cloud.repository.EthereumPriceRepository;

import java.util.List;

@Service
public class EthereumPriceService {

    @Autowired
    private EthereumPriceRepository ethRepository;

    public EthereumPrice save(EthereumPrice eth) {
        ethRepository.save(eth);
        return eth;
    }

    public List<EthereumPrice> getAllBtc() {
        return ethRepository.findAll();
    }

}

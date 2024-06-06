package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.model.BitcoinPrice;
import com.cloud.repository.BitcoinPriceRepository;

import java.util.List;

@Service
public class BitcoinPriceService {

    @Autowired
    private BitcoinPriceRepository btcRepository;

    public BitcoinPrice save(BitcoinPrice btc) {
        btcRepository.save(btc);
        return btc;
    }

    public List<BitcoinPrice> getAllBtc() {
        return btcRepository.findAll();
    }

}

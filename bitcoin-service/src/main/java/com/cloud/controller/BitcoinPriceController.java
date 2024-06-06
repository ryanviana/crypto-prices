package com.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.model.BitcoinPrice;
import com.cloud.service.BitcoinPriceService;

@RestController
@RequestMapping("/btc")
public class BitcoinPriceController {

    @Autowired
    private BitcoinPriceService btcService;

    @PostMapping
    public ResponseEntity<BitcoinPrice> saveEndereco(@RequestBody BitcoinPrice btc) {
        btcService.save(btc);
        return ResponseEntity.ok(btc);
    }

    @GetMapping
    public ResponseEntity<List<BitcoinPrice>> getListaBitcoinPrice() {
        List<BitcoinPrice> listaBitcoinPrice = btcService.getAllBtc();
        return ResponseEntity.ok(listaBitcoinPrice);
    }

}
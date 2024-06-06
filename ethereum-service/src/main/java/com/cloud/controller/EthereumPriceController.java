package com.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.model.EthereumPrice;
import com.cloud.service.EthereumPriceService;

@RestController
@RequestMapping("/eth")
public class EthereumPriceController {

    @Autowired
    private EthereumPriceService ethService;

    @PostMapping
    public ResponseEntity<EthereumPrice> saveEndereco(@RequestBody EthereumPrice eth) {
        ethService.save(eth);
        return ResponseEntity.ok(eth);
    }

    @GetMapping
    public ResponseEntity<List<EthereumPrice>> getListaEthereumPrice() {
        List<EthereumPrice> listaEthereumPrice = ethService.getAllBtc();
        return ResponseEntity.ok(listaEthereumPrice);
    }

}
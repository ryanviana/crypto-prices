package com.cloud.kafka;

import com.cloud.model.BitcoinPrice;
import com.cloud.service.BitcoinPriceService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BitcoinConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BitcoinConsumer.class);
    private static final String TOPIC = "bitcoin-price";
    private static final String GROUP_ID = "bitcoin-price-group";

    @Autowired
    private BitcoinPriceService bitcoinPriceService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consume(String message) {
        LOGGER.info(String.format("CONSUMER: #### -> Consumed message -> %s", message));
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            BitcoinPrice bitcoinPrice = new BitcoinPrice();
            bitcoinPrice.setTimestamp(jsonNode.path("time").asText());
            bitcoinPrice.setPrice(jsonNode.path("close").asText());
            bitcoinPriceService.save(bitcoinPrice);
        } catch (Exception e) {
            LOGGER.error("Failed to process message", e);
        }
    }
}

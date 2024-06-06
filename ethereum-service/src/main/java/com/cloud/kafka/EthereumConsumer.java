package com.cloud.kafka;

import com.cloud.model.EthereumPrice;
import com.cloud.service.EthereumPriceService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EthereumConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EthereumConsumer.class);
    private static final String TOPIC = "ethereum-price";
    private static final String GROUP_ID = "ethereum-price-group";

    @Autowired
    private EthereumPriceService ethereumPriceService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consume(String message) {
        LOGGER.info(String.format("CONSUMER: #### -> Consumed message -> %s", message));
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            EthereumPrice ethereumPrice = new EthereumPrice();
            ethereumPrice.setTimestamp(jsonNode.path("time").asText());
            ethereumPrice.setPrice(jsonNode.path("close").asText());
            ethereumPriceService.save(ethereumPrice);
        } catch (Exception e) {
            LOGGER.error("Failed to process message", e);
        }
    }
}

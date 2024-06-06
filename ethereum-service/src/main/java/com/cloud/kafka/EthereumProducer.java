package com.cloud.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class EthereumProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EthereumProducer.class);
    private static final String CRYPTOCOMPARE_API_URL = "https://min-api.cryptocompare.com/data/v2/histominute?fsym=ETH&tsym=USD&limit=1";
    private static final String TOPIC = "ethereum-price";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public EthereumProducer(KafkaTemplate<String, String> kafkaTemplate, RestTemplate restTemplate,
            ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Scheduled(fixedRate = 60000) // Fetch every 10 seconds
    public void sendEthereumUpdate() {
        try {
            String response = restTemplate.getForObject(CRYPTOCOMPARE_API_URL, String.class);
            JsonNode jsonNode = objectMapper.readTree(response);
            JsonNode dataNode = jsonNode.path("Data").path("Data").get(0); // Get the first data point
            String message = objectMapper.writeValueAsString(dataNode);
            LOGGER.info("PRODUCER: Sending message to topic {}: {}", TOPIC, message);
            kafkaTemplate.send(TOPIC, message);
        } catch (IOException e) {
            LOGGER.error("Error fetching or parsing data from CryptoCompare API", e);
        }
    }
}
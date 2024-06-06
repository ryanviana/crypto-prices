package com.cloud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "ethereum_prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EthereumPrice {

    @Id
    private String id;
    private String timestamp;
    private String price;
}

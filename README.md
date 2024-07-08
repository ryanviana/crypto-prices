# Crypto Prices

Crypto Pirces is a scalable and reactive system for monitoring cryptocurrency prices, specifically Bitcoin and Ethereum. It utilizes modern technologies like Kafka, Spring Boot, and MongoDB to capture, process, and store real-time price data.

## Overview

The cryptocurrency market is highly volatile, with asset prices such as Bitcoin and Ethereum fluctuating significantly in short periods. Crypto Watch was developed to provide a robust solution for continuous cryptocurrency price monitoring, ensuring low latency and high reliability.

## Architecture

The system architecture consists of the following main components:

- **Crypto Compare API**: Data source for cryptocurrency prices.
- **BTC Producer and ETH Producer**: Services that consume data from the API and produce messages for Kafka.
- **Kafka**: Event streaming platform that manages message delivery.
- **BTC Consumer and ETH Consumer**: Services that consume messages from Kafka and store the data in MongoDB.
- **MongoDB**: NoSQL database for storing price data.
- **BTC Rest Endpoint and ETH Rest Endpoint**: REST endpoints for accessing price data.
- **Client**: User or application that consumes data via REST endpoints.

## Prerequisites

- Docker
- Docker Compose

## How to Run

Follow the steps below to set up and run the project:

### Step by Step

1. Clone the GitHub repository:
    ```sh
    git clone https://github.com/ICMC-SSC0158-2024/gcloudgrad04
    cd gcloudgrad04
    ```

2. Run the setup script:
    ```sh
    ./setup.sh
    ```

3. Build and start the Docker containers:
    ```sh
    docker-compose up --build
    ```

## Ports and APIs

After starting the containers, the following services will be available at their respective ports:

- **Kafka Monitor (Kafdrop)**: [http://localhost:19000](http://localhost:19000)
- **Mongo Express**: [http://localhost:8085](http://localhost:8085)
- **Ethereum API**: [http://localhost:6054/eth](http://localhost:6054/eth)
- **Bitcoin API**: [http://localhost:5054/btc](http://localhost:5054/btc)

## Data Flow

The data flow in the system occurs as follows:

1. The Crypto Compare API provides the current prices of Bitcoin and Ethereum.
2. The BTC Producer and ETH Producer services consume this data from the API and produce messages for Kafka.
3. Kafka delivers these messages to the consumers.
4. The BTC Consumer and ETH Consumer services consume the messages and store the data in MongoDB.
5. The BTC Rest Endpoint and ETH Rest Endpoint provide access to the stored data.
6. The Client consumes the price data through the REST endpoints.

## Results

The price data of Bitcoin and Ethereum is collected and stored in MongoDB. The system performance analysis demonstrated Kafka's efficiency in message delivery, with low latency and high reliability. In terms of storage, MongoDB proved efficient for read and write operations.

## Installation of `jq`

If you do not have `jq` installed on your machine:

### For Debian/Ubuntu systems:

```sh
sudo apt-get install jq
```

## Example Request with curl and jq
You can use curl and jq to make requests to the REST endpoints and format the output. Here is an example of how to get Bitcoin prices:

```sh
curl -X GET http://localhost:5054/btc | jq
curl -X GET http://localhost:6054/eth | jq
```

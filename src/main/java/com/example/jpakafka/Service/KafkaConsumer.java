package com.example.jpakafka.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    public final RestTemplate restTemplate;

    public KafkaConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @KafkaListener(topics = "consume_topic", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info("Consumed Message  successfully {}", message);
        try {
            restTemplate.getForEntity("http://localhost:8081/kafka/publish/" + message, String.class);
            LOGGER.info("Message Successfully send");
        } catch (Exception err) {
            LOGGER.error(err.getMessage());
        }
        try {
            String text = message.toUpperCase();
            restTemplate.getForEntity("http://localhost:8081/library/" + text, String.class);
            LOGGER.info("Message:{}  converted to UpperCase and send successfully", text);
        } catch (Exception err) {
            LOGGER.error(err.getMessage());
        }
    }
}

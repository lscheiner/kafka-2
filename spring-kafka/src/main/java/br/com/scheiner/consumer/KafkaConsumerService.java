package br.com.scheiner.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.scheiner.Employee;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "employee", groupId = "group-id")
    public void consumeMessage(Employee message) {
        System.out.println("Consumed message: " + message);
    }
}

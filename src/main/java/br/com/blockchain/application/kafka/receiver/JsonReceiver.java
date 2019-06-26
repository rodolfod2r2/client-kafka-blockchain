package br.com.blockchain.application.kafka.receiver;

import br.com.blockchain.application.model.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class JsonReceiver {

    @KafkaListener(topics = "Kafka_example", groupId = "conductor", containerFactory = "listenerContainerFactory")
    public void listenMessagem(@Payload List<Cliente> clienteList) {
        for (Cliente item : clienteList) {
            System.out.println(item.getTexto());
        }
    }

}

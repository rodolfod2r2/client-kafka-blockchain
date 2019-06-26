package br.com.blockchain.application.kafka.sender;

import br.com.blockchain.application.model.Cliente;
import br.com.blockchain.application.kafka.configure.JsonSenderConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class JsonSender {

    @Value("topicname")
    private String jsonTopic;

    @Autowired
    JsonSenderConfig jsonSenderConfig;

    @Bean
    public void send() {
        Cliente cliente = new Cliente();
        cliente.setTexto("nome do cliente");
        log.info("enviando client ='{}'", cliente.toString());
        jsonSenderConfig.kafkaJsonTemplate().send(jsonTopic, cliente);
    }
}

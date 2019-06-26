package br.com.blockchain.application.kafka.configure;

import br.com.blockchain.application.kafka.sender.JsonSender;
import br.com.blockchain.application.model.Cliente;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
@EnableKafka
public class JsonSenderConfig extends ReceiverConfig {

    @ConditionalOnMissingBean(ProducerFactory.class)
    private ProducerFactory<String, Cliente> producerJsonFactory() {
        return new DefaultKafkaProducerFactory<>(producerJsonConfigs());
    }

    @Bean
    public KafkaTemplate<String, Cliente> kafkaJsonTemplate() {
        return new KafkaTemplate<>(producerJsonFactory());
    }

    @Bean
    public JsonSender jsonSender() {
        return new JsonSender();
    }


}

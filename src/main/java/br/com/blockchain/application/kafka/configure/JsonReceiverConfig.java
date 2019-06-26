package br.com.blockchain.application.kafka.configure;

import br.com.blockchain.application.kafka.receiver.JsonReceiver;
import br.com.blockchain.application.model.Cliente;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
@EnableKafka
public class JsonReceiverConfig extends ReceiverConfig {

    @ConditionalOnMissingBean(ConsumerFactory.class)
    public ConsumerFactory<String, Cliente> consumerJsonFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerJsonConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(Cliente.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Cliente> listenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Cliente> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerJsonFactory());
        factory.setBatchListener(true);
        return factory;
    }


    @Bean
    public JsonReceiver receiverJson() {
        return new JsonReceiver();
    }

}

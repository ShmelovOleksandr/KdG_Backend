package be.kdg.prog6.boundedcontextWaterside.adapter.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopology {
    public static final String WAREHOUSE_EVENTS_EXCHANGE = "warehouse_events";
    public static final String MATERIAL_UNLOADED_QUEUE = "material_unloaded";

    @Bean
    TopicExchange warehouseEventsExchange() {
        return new TopicExchange(WAREHOUSE_EVENTS_EXCHANGE);
    }

    @Bean
    Queue materialUnloadedQueue() {
        return new Queue(MATERIAL_UNLOADED_QUEUE, true);
    }

    @Bean
    Binding warehosueDumpBinding(TopicExchange warehouseEventsExchange, Queue materialUnloadedQueue) {
        return BindingBuilder
                .bind(materialUnloadedQueue)
                .to(warehouseEventsExchange)
                .with("warehouse.#.material.unloaded");
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}

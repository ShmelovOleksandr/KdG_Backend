package be.kdg.prog6.boundedcontextLandside.adapter.in.rabbitmq;

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
    public static final String WEIGHTING_BRIDGE_EVENTS_EXCHANGE = "weighting_bridge_events";
    public static final String WEIGHTING_BRIDGE_PASSAGE_QUEUE = "truck_movement";

    public static final String WAREHOUSE_EVENTS_EXCHANGE = "warehouse_events";
    public static final String MATERIAL_UPDATED_QUEUE = "material_updated";

    @Bean
    TopicExchange warehouseEventsExchange() {
        return new TopicExchange(WAREHOUSE_EVENTS_EXCHANGE);
    }

    @Bean
    Queue materialUpdatedQueue() {
        return new Queue(MATERIAL_UPDATED_QUEUE, true);
    }

    @Bean
    Binding warehosueBinding(TopicExchange warehouseEventsExchange, Queue materialUpdatedQueue) {
        return BindingBuilder
                .bind(materialUpdatedQueue)
                .to(warehouseEventsExchange)
                .with("warehouse.#.material.updated");
    }

    @Bean
    TopicExchange weightingBridgeEventsExchange() {
        return new TopicExchange(WEIGHTING_BRIDGE_EVENTS_EXCHANGE);
    }

    @Bean
    Queue truckQueue() {
        return new Queue(WEIGHTING_BRIDGE_PASSAGE_QUEUE, true);
    }

    @Bean
    Binding weightingBridgeBinding(TopicExchange weightingBridgeEventsExchange, Queue truckQueue) {
        return BindingBuilder
                .bind(truckQueue)
                .to(weightingBridgeEventsExchange)
                .with("weightingbridge.passed");
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

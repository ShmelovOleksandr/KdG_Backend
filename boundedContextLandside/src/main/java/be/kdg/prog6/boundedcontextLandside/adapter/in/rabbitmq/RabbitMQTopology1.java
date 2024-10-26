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
public class RabbitMQTopology1 {
    public static final String APPOINTMENT_EVENTS_EXCHANGE = "appointment_events";
    public static final String MATERIAL_WEIGHTED_QUEUE = "material_weighted";

    public static final String WAREHOUSE_EVENTS_EXCHANGE = "warehouse_events";
    public static final String MATERIAL_UPDATED_QUEUE = "material_updated";
    public static final String MATERIAL_DUMPED_QUEUE = "material_dumped";

    @Bean
    TopicExchange warehouseEventsExchange() {
        return new TopicExchange(WAREHOUSE_EVENTS_EXCHANGE);
    }

    @Bean
    Queue materialUpdatedQueue() {
        return new Queue(MATERIAL_UPDATED_QUEUE, true);
    }

    @Bean
    Binding warehosueUpdateBinding(TopicExchange warehouseEventsExchange, Queue materialUpdatedQueue) {
        return BindingBuilder
                .bind(materialUpdatedQueue)
                .to(warehouseEventsExchange)
                .with("warehouse.#.material.updated");
    }

    @Bean
    Queue materialDumpedQueue() {
        return new Queue(MATERIAL_DUMPED_QUEUE, true);
    }

    @Bean
    Binding warehosueDumpBinding(TopicExchange warehouseEventsExchange, Queue materialDumpedQueue) {
        return BindingBuilder
                .bind(materialDumpedQueue)
                .to(warehouseEventsExchange)
                .with("warehouse.#.material.dumped");
    }

    @Bean
    TopicExchange appointmentEventsExchange() {
        return new TopicExchange(APPOINTMENT_EVENTS_EXCHANGE);
    }

    @Bean
    Queue materialWeightedQueue() {
        return new Queue(MATERIAL_WEIGHTED_QUEUE, true);
    }

    @Bean
    Binding weightingBridgeBinding(TopicExchange appointmentEventsExchange, Queue materialWeightedQueue) {
        return BindingBuilder
                .bind(materialWeightedQueue)
                .to(appointmentEventsExchange)
                .with("appointment.#.material.weighted");
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

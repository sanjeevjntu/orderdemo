package com.example.sanjeev.orderdemo.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Setter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import java.text.SimpleDateFormat;


@Configuration
@Setter
public class OrderSubscriberConfiguration implements RabbitListenerConfigurer {

    public static final String DLQ_ORDER_CREATE_QUEUE = "DLQ.ORDER.CREATE.QUEUE";

    @Value("${rabbitmq.order.queue}")
    private String orderQueue;

    @Value("${rabbitmq.order.routingKey}")
    private String routingKey;

    @Value("${rabbitmq.order.exchange}")
    private String orderExchange;

    @Value("${rabbitmq.order.retryExchange}")
    private String retryExchange;

    @Bean
    public Queue orderQueue() {
        return QueueBuilder.durable(orderQueue)
                // .withArgument("x-dead-letter-exchange", retryExchange)
                // .withArgument("x-dead-letter-routing-key", orderQueue)
                .build();
    }

    @Bean
    public Queue orderDeadLetterQueue() {
        return QueueBuilder.durable(DLQ_ORDER_CREATE_QUEUE)
                // .withArgument("x-dead-letter-exchange", orderExchange)
                //  .withArgument("x-message-ttl", 5000)
                .build();
    }

//    @Bean
//    public Queue mainQueue() {
//        Map<String, Object> args = new HashMap<>();
//
//        args.put("x-dead-letter-exchange", exchange.getRetry());
//        args.put("x-dead-letter-routing-key", queue.getMain());
//        return new Queue(queue.getMain(), true, false, false, args);
//    }

//    @Bean
//    public Queue retryQueue() {
//        Map<String, Object> args = new HashMap<>();
//
//        args.put("x-dead-letter-exchange", exchange.getMain());
//        args.put("x-message-ttl", retry.getDelay());
//        return new Queue(queue.getRetry(), true, false, false, args);
//    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(orderExchange);
    }

    @Bean
    public Binding orderQueueBinding(Queue orderQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with(routingKey);
    }


    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }

    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.getObjectMapper();
        return mappingJackson2MessageConverter;
    }

    @Bean
    // @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.build();

        // objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        return objectMapper;
    }

/*    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(UTC_TIME_ZONE);
        mapper.setDateFormat(ISO_8601_DATE_FORMAT);
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }*/

/*    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
        return mappingJackson2HttpMessageConverter;
    }*/

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter());
//        super.configureMessageConverters(converters);
//    }

//    @Autowired
//    private ConnectionFactory cachingConnectionFactory;
//
//    // Setting the annotation listeners to use the jackson2JsonMessageConverter
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(cachingConnectionFactory);
//        factory.setMessageConverter(jackson2JsonMessageConverter());
//        return factory;
//    }
//
//    // Standardize on a single objectMapper for all message queue items
//    @Bean
//    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }

}

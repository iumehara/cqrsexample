package com.example.messagebroker;


import com.example.messagebroker.message.event.NewProductAdded;
import com.example.messagebroker.message.event.ProductRated;
import com.example.productsquery.dataprojector.handler.ProductsEventHandler;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.example.messagebroker.QueueName.NEW_PRODUCT_ADDED;
import static com.example.messagebroker.QueueName.PRODUCT_RATED;
import static java.util.Objects.requireNonNull;
import static org.springframework.util.SerializationUtils.deserialize;


@Service
public class Receiver {
    private ProductsEventHandler productsEventHandler;

    public Receiver(ProductsEventHandler productsEventHandler) throws IOException, TimeoutException {
        this.productsEventHandler = productsEventHandler;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        consumeNewProductAddedQueue(channel);
    }

    private void consumeNewProductAddedQueue(Channel channel) throws IOException {
        String queueName = NEW_PRODUCT_ADDED.name();
        channel.queueDeclare(queueName, false, false, false, null);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            this.productsEventHandler.handle((NewProductAdded) requireNonNull(deserialize(delivery.getBody())));
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

    private void consumeProductRatedQueue(Channel channel) throws IOException {
        String queueName = PRODUCT_RATED.name();
        channel.queueDeclare(queueName, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            this.productsEventHandler.handle((ProductRated) requireNonNull(deserialize(delivery.getBody())));
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}

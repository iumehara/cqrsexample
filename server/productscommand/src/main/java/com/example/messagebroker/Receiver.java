package com.example.messagebroker;

import com.example.productscommand.handler.ProductsCommandHandler;
import com.example.messagebroker.message.command.AddNewProduct;
import com.example.messagebroker.message.command.RateProduct;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.example.messagebroker.QueueName.ADD_NEW_PRODUCT;
import static com.example.messagebroker.QueueName.RATE_PRODUCT;
import static java.util.Objects.requireNonNull;
import static org.springframework.util.SerializationUtils.deserialize;

@Component
public class Receiver {
    private ProductsCommandHandler commandHandler;

    public Receiver(ProductsCommandHandler commandHandler) throws IOException, TimeoutException {
        this.commandHandler = commandHandler;
        startListening();
    }

    public void startListening() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        consumeAddNewProductQueue(channel);
        consumeRateProductQueue(channel);
    }

    private void consumeAddNewProductQueue(Channel channel) throws IOException {
        String queueName = ADD_NEW_PRODUCT.name();
        channel.queueDeclare(queueName, false, false, false, null);
        channel.basicConsume(
                queueName,
                true,
                (consumerTag1, delivery) -> commandHandler.handle((AddNewProduct) requireNonNull(deserialize(delivery.getBody()))),
                consumerTag -> {
                });
    }

    private void consumeRateProductQueue(Channel channel) throws IOException {
        String queueName = RATE_PRODUCT.name();
        channel.queueDeclare(queueName, false, false, false, null);
        channel.basicConsume(
                queueName,
                true,
                (consumerTag1, delivery) -> commandHandler.handle((RateProduct) requireNonNull(deserialize(delivery.getBody()))),
                consumerTag -> {
                });
    }
}
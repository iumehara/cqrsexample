package com.example.messagebroker;

import com.example.messagebroker.message.Message;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Sender {
    private Connection connection;

    public Sender() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connection = connectionFactory.newConnection();
    }

    public void send(Message message) {
        try {
            Channel channel = connection.createChannel();
            String queueName = message.getQueueName().name();
            channel.queueDeclare(queueName, false, false, false, null);
            byte[] serializedMessage = SerializationUtils.serialize(message);
            channel.basicPublish("", queueName, null, serializedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

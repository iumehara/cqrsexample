package com.example.messagebroker.message;

import com.example.messagebroker.QueueName;

import java.io.Serializable;
import java.util.UUID;

public interface Message extends Serializable {
    UUID getId();

    QueueName getQueueName();
}

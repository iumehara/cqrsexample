package com.example.productscommand.messagebroker;

import com.example.messagebroker.message.event.NewProductAdded;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.SerializationUtils.deserialize;
import static org.springframework.util.SerializationUtils.serialize;

public class SerializationTests {
    @Test
    void newProductAdded() {
        NewProductAdded newProductAdded = new NewProductAdded(1234);

        byte[] serializedMessage = serialize(newProductAdded);

        NewProductAdded deserializedMessage = (NewProductAdded) deserialize(serializedMessage);

        assertThat(deserializedMessage.getProductId()).isEqualTo(1234);
    }
}

package br.com.lab;

import org.apache.kafka.clients.producer.Callback;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var dispatcher = new KafkaDispatcher()) {

            var key = UUID.randomUUID().toString();
            var value = key + ",74158,98656";
            dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
            var email = "Thank you for your order! We are processing you order";
            dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
        }
    }


}

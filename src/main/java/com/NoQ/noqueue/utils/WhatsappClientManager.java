package com.NoQ.noqueue.utils;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import nl.xx1.whatsapp4j.Client;
import nl.xx1.whatsapp4j.ClientLaunchOptions;
import nl.xx1.whatsapp4j.Event;
import nl.xx1.whatsapp4j.auth.LocalAuth;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class WhatsappClientManager {
    @Getter
    private Client client;
    public final AtomicBoolean isReady = new AtomicBoolean(false);

    @PostConstruct
    public void init(){
        client = new Client(ClientLaunchOptions.builder().authStrategy(new LocalAuth()).build());
        client.on(Event.QR_READY, qr -> {
            System.out.println("SCAN THIS CODE");
            System.out.println(qr);
        });
        client.on(Event.READY, obj -> {
            isReady.set(true);
            System.out.println("whatsapp connected");
        });
        client.start();
    }

}

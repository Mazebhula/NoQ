package com.NoQ.noqueue.service;

import com.NoQ.noqueue.utils.WhatsappClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {

    @Autowired
    private WhatsappClientManager clientManager;

    public void sendMessage(String phone, String text){
        if (!clientManager.isReady.get()){
            throw new IllegalStateException("whatsapp not connected");
        }
        clientManager.getClient().sendMessage(phone,text);
    }
}

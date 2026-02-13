package com.NoQ.noqueue.controller;

import com.NoQ.noqueue.model.Queued;
import com.NoQ.noqueue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QueueController {

    @Autowired
    QueueService queue;


    @GetMapping("/")
    public List<Queued> showQueue(){
        return queue.showQ();
    }
    @GetMapping("/queue")
    public Queued queue(){
        return queue.addToQueue();
    }
}

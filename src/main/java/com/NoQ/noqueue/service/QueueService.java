package com.NoQ.noqueue.service;

import com.NoQ.noqueue.model.Queued;
import com.NoQ.noqueue.repository.QueueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class QueueService {


    private final Instant START_TIME  = Instant.now();
    int wait = 5;
    @Autowired
    QueueRepo repo;

    public List<Queued> showQ(){return repo.findAll();}

    public Queued addToQueue(){
        int QNum = Math.toIntExact(repo.count())+1;
        Duration Tts = tts(QNum);

        Queued Q = new Queued(QNum,Tts);
        repo.save(Q);
        return Q;
    }
    private Duration tts(int QNum){
        Instant now = Instant.now();
        Duration elapsed = Duration.between(START_TIME,now);
        long completedSlots = elapsed.toMinutes() / wait ;
        long effectivePos = QNum - completedSlots;
        if (effectivePos < 0 ){
            effectivePos = 0;
        }
        return Duration.ofMinutes(wait).multipliedBy(effectivePos);
    }
}

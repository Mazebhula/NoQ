package com.NoQ.noqueue.repository;

import com.NoQ.noqueue.model.Queued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepo extends JpaRepository<Queued, Integer> {
}

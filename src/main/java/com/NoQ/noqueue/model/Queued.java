package com.NoQ.noqueue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Queued {
    @Id
    private int id;
    private Duration timeToService;
}

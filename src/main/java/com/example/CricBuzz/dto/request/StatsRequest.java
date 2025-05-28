package com.example.CricBuzz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatsRequest {
    int runs;
    int wickets;
    double battingAvg;
    double bowlingAvg;
    int playerId;
}

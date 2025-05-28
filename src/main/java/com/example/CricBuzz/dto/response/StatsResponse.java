package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.model.Player;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsResponse {
    int runs;
    int wickets;
    PlayerResponse player;
}

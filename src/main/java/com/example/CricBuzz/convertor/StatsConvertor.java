package com.example.CricBuzz.convertor;

import com.example.CricBuzz.dto.request.StatsRequest;
import com.example.CricBuzz.dto.response.StatsResponse;
import com.example.CricBuzz.model.Stats;

public class StatsConvertor {
    public static Stats statsRequestToStats(StatsRequest statsRequest){
        return Stats.builder().runs(statsRequest.getRuns())
                .wickets(statsRequest.getWickets())
                .bowlingAvg(statsRequest.getBowlingAvg())
                .battingAvg(statsRequest.getBattingAvg()).build();
    }
    public static StatsResponse statsToStatsResponse(Stats stats){
        return StatsResponse.builder()
                .runs(stats.getRuns())
                .wickets(stats.getWickets())
                .player(PlayerConvertor.playerToPlayerResponse(stats.getPlayer()))
                .build();
    }
}

package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.StatsConvertor;
import com.example.CricBuzz.dto.request.StatsRequest;
import com.example.CricBuzz.dto.response.StatsResponse;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.Stats;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {
      @Autowired
      PlayerRepository playerRepository;
    public StatsResponse addStats(StatsRequest statsRequest, int playerId) {

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player id");
        }
        Player player = optionalPlayer.get();

        Stats stats = StatsConvertor.statsRequestToStats(statsRequest);

        player.setStats(stats);
        stats.setPlayer(player);

        Player savedPlayer = playerRepository.save(player);

        return StatsConvertor.statsToStatsResponse(savedPlayer.getStats());
    }




}

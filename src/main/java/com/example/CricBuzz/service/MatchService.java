package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.MatchConvertor;
import com.example.CricBuzz.dto.request.MatchRequest;
import com.example.CricBuzz.dto.response.MatchResponse;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.model.CricketMatch;
import com.example.CricBuzz.model.Team;
import com.example.CricBuzz.repository.MatchRepository;
import com.example.CricBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MatchRepository matchRepository;

    public MatchResponse registerMatch(MatchRequest matchRequest, int teamAId, int teamBId){
        Optional<Team> optionalTeamA = teamRepository.findById(teamAId);
        Optional<Team> optionalTeamB = teamRepository.findById(teamBId);

        if(optionalTeamA.isEmpty() || optionalTeamB.isEmpty()){
            throw new TeamNotFoundException("One or more team id(s) is not valid");
        }

        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();

        CricketMatch match = MatchConvertor.matchRequestToMacth(matchRequest);
        match.getTeams().add(teamA);
        match.getTeams().add(teamB);

        teamA.setMatchPlayed(teamA.getMatchPlayed()+1);
        teamA.getMatches().add(match);

        teamB.setMatchPlayed(teamB.getMatchPlayed()+1);
        teamB.getMatches().add(match);

        CricketMatch savedMatch = matchRepository.save(match);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConvertor.matchToMatchResponse(savedMatch);
    }
}

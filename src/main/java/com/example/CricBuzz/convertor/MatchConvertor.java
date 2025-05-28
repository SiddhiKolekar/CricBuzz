package com.example.CricBuzz.convertor;

import com.example.CricBuzz.dto.request.MatchRequest;
import com.example.CricBuzz.dto.response.MatchResponse;
import com.example.CricBuzz.dto.response.TeamResponse;
import com.example.CricBuzz.model.CricketMatch;

import java.util.ArrayList;
import java.util.List;

public class MatchConvertor {
    public static CricketMatch matchRequestToMacth(MatchRequest matchRequest){
        return CricketMatch.builder().title(matchRequest.getTitle())
                .venue(matchRequest.getVenue())
                .teams(new ArrayList<>())
                .build();
    }

    public static MatchResponse matchToMatchResponse(CricketMatch match){
        List<TeamResponse> teams = new ArrayList<>();
        teams.add(TeamConvertor.teamToTeamResponse(match.getTeams().get(0)));
        teams.add(TeamConvertor.teamToTeamResponse(match.getTeams().get(1)));

        return MatchResponse.builder()
                .title(match.getTitle())
                .venue(match.getVenue())
                .created(match.getCreated())
                .teams(teams)
                .build();
    }
}

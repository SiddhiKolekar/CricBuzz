package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.model.Team;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchResponse {
    String title;
    String venue;
    Date created;
    List<TeamResponse> teams;
}

package com.example.CricBuzz.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamResponse {
    String name;
    int ranking;
    String coach;
}

package com.example.CricBuzz.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequest {
    String name;
    int ranking;
    int iccPoints;
    String coach;
}

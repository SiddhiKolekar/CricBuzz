package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.model.enums.Speciality;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerResponse {
    String name;
    Speciality speciality;

}

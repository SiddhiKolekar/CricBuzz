package com.example.CricBuzz.convertor;

import com.example.CricBuzz.dto.request.PlayerRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.model.Player;

public class PlayerConvertor {
    public static Player playerRequestToPlayer(PlayerRequest playerRequest){
        return Player.builder().name(playerRequest.getName())
                .age(playerRequest.getAge())
                .speciality(playerRequest.getSpeciality())
                .gender(playerRequest.getGender())
                .email(playerRequest.getEmail()).build();
    }

    public static PlayerResponse playerToPlayerResponse(Player player){
        return PlayerResponse.builder()
                .name(player.getName())
                .speciality(player.getSpeciality())
                .build();
    }
}

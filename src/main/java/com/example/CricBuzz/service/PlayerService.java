package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.PlayerConvertor;
import com.example.CricBuzz.dto.request.PlayerRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.enums.Gender;
import com.example.CricBuzz.model.enums.Speciality;
import com.example.CricBuzz.repository.PlayerRepository;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    JavaMailSender javaMailSender;
    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        Player player = PlayerConvertor.playerRequestToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        sendEmail(savedPlayer);
        return PlayerConvertor.playerToPlayerResponse(savedPlayer);
    }

    private void sendEmail(Player player){
        String text = "Hi!" + player.getName()+ ", Your profile has been registered on CricBuzz";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("siddhikolekar11@gmail.com");
        message.setTo(player.getEmail());
        message.setSubject("Congrats!! you have been registered");
        message.setText(text);

        javaMailSender.send(message);
    }
    public PlayerResponse getPlayerById(int id){
      Optional<Player> playerOptional =  playerRepository.findById(id);
      if(playerOptional.isEmpty()){
          throw new PlayerNotFoundException("Player with id: "+id+" doesn't exist");
      }
      return PlayerConvertor.playerToPlayerResponse(playerOptional.get());
    }

    public List<PlayerResponse> findByGenderAndAgeGreaterThan(Gender gender, int age){
        List<Player> players = playerRepository.findByGenderAndAgeGreaterThan(gender, age);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for (Player player : players){
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }
        return playerResponses;
    }

    public List<PlayerResponse> getByGenderAndSpeciality(Gender gender, Speciality speciality){
        List<Player> players = playerRepository.getByGenderAndSpeciality(gender, speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player : players){
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }
        return playerResponses;
    }
}

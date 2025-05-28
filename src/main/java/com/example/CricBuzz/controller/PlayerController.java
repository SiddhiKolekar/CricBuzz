package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.PlayerRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.enums.Gender;
import com.example.CricBuzz.model.enums.Speciality;
import com.example.CricBuzz.service.PlayerService;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.hibernate.generator.values.AbstractGeneratedValuesMutationDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @PostMapping
    public ResponseEntity<PlayerResponse> addPlayer(@RequestBody PlayerRequest playerRequest){
       return new ResponseEntity<>(playerService.addPlayer(playerRequest),HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getPlayerById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(playerService.getPlayerById(id),HttpStatus.OK);
        }
        catch (PlayerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<PlayerResponse> getByGenderAndAgeGreaterThan(@PathVariable("gender") Gender gender, @PathVariable("age") int age){
        return playerService.findByGenderAndAgeGreaterThan(gender, age);
    }
    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getByGenderAndSpeciality(@PathVariable("gender") Gender gender, @PathVariable("speciality")Speciality speciality){
        return playerService.getByGenderAndSpeciality(gender, speciality);
    }
}

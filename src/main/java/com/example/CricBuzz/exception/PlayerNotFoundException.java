package com.example.CricBuzz.exception;

import com.example.CricBuzz.dto.response.PlayerResponse;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String message){
        super(message);
    }
}

package com.fcoach.player;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "player with this name already exists")
public class PlayerNameTakenException extends RuntimeException {
  public PlayerNameTakenException(String msg) {
    super(msg);
  }
}
